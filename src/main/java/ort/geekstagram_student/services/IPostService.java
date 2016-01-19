package ort.geekstagram_student.services;

import java.util.ArrayList;

import ort.geekstagram_student.Entities.PostEntity;

public interface IPostService {
	
	public void add(PostEntity comment);
	public ArrayList<PostEntity> getAll();
	public PostEntity getById(long id);
	public void update(long id, PostEntity comment);
	public void remove(long id);

}
