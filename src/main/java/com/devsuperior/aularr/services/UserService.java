package com.devsuperior.aularr.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aularr.dto.UserDTO;
import com.devsuperior.aularr.entities.User;
import com.devsuperior.aularr.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> result = repository.findAll();
		return result.stream().map(x -> new UserDTO(x, x.getFollowing(), x.getFollowers())).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<UserDTO> getFollowing(Long id) {
		User result = repository.getOne(id);
		return result.getFollowing().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<UserDTO> getFollowers(Long id) {
		User result = repository.getOne(id);
		return result.getFollowers().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
}
