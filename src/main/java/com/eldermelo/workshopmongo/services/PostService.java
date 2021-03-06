package com.eldermelo.workshopmongo.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxdate){
		maxdate = new Date(maxdate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxdate);
	}
}