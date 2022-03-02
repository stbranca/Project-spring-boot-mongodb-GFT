package com.eldermelo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldermelo.workshopmongo.domain.User;
import com.eldermelo.workshopmongo.repository.UserRepository;
import com.eldermelo.workshopmongo.services.exception.ObjectNotFaundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
		
	}
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFaundException("Objeto não encontrado"));
	}
}
