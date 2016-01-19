package ort.geekstagram_student.controllers;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ort.geekstagram_student.Entities.PostEntity;
import ort.geekstagram_student.services.IPostService;
import ort.geekstagram_student.services.MysqlPostService;


@CrossOrigin
@RestController
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

	@RequestMapping(method = RequestMethod.GET, value = "/posts", produces="application/json")
	public Iterable<PostEntity> getAll() {
		ArrayList<PostEntity> list = service.getAll();
		return list;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/posts/{id}", produces="application/json")
	public PostEntity getById(@PathVariable("id") long id) {
		return service.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/posts")
	public void add(@RequestBody PostEntity post) {
		service.add(post);
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
