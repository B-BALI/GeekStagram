package ort.geekstagram_student.controllers;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ort.geekstagram_student.Entities.PostEntity;
import ort.geekstagram_student.domain.CurrentUser;
import ort.geekstagram_student.services.IPostService;


@CrossOrigin
@Controller
public class PostController {



	@Autowired
	@Qualifier("MysqlPostService")
	IPostService service;

	public IPostService getService() {
		return service;
	}

	public void setService(IPostService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getAll(Model model) {
		ArrayList<PostEntity> posts;
		posts = service.getAll();
		Collections.reverse(posts);
		model.addAttribute("posts",(ArrayList<PostEntity>)posts);
		model.addAttribute("post", new PostEntity());
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/posts/{id}", produces="application/json")
	public PostEntity getById(@PathVariable("id") long id) {
		return service.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/posts")
	public String add(CurrentUser currentUser,@ModelAttribute PostEntity post) {
		post.setUser(currentUser.getUser());
		Date now = new Date();
		post.setDate(now.getTime());
		service.add(post);
		return "redirect:/";
	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/posts/{id}")
	public void delete(@PathVariable("id") long id) {
		service.remove(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/posts/{id}")
	public void update(@PathVariable("id") long id, @RequestBody PostEntity post) {
		service.update(id, post);
	}
	
}
