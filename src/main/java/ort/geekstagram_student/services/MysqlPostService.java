package ort.geekstagram_student.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ort.geekstagram_student.Entities.PostEntity;
import ort.geekstagram_student.repositories.IPostRepository;

@Component
@Qualifier("MysqlPostService")
public class MysqlPostService implements IPostService {

	public IPostRepository getRepository() {
		return repository;
	}

	public void setRepository(IPostRepository repository) {
		this.repository = repository;
	}

	@Autowired
	IPostRepository repository;
	
	
	@Override
	public void add(PostEntity comment){
		repository.save(comment);	
	}
	
	@Override
	public ArrayList<PostEntity> getAll(){
		return (ArrayList<PostEntity>)repository.findAll();
	}
	
	@Override
	public PostEntity getById(long id){
		return repository.findOne(id);
	}
	
	@Override
	public void update(long id, PostEntity post){
		
		post.setId(id);
		repository.save(post);
	}
	
	@Override
	public void remove(long id){
		repository.delete(id);
	}
}
