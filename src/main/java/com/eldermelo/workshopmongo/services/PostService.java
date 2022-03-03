package com.eldermelo.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldermelo.workshopmongo.domain.Post;
import com.eldermelo.workshopmongo.repository.PostRepository;
import com.eldermelo.workshopmongo.services.exception.ObjectNotFaundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFaundException("Objeto não encontrado"));
	}
	
}