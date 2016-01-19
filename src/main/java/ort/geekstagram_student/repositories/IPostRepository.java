package ort.geekstagram_student.repositories;

import org.springframework.data.repository.CrudRepository;

import ort.geekstagram_student.Entities.PostEntity;

public interface IPostRepository extends CrudRepository<PostEntity, Long> {
	
}

