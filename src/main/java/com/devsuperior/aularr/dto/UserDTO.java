package com.devsuperior.aularr.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.devsuperior.aularr.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	private Set<UserDTO> following = new HashSet<>();
	
	private Set<UserDTO> followers = new HashSet<>();
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
	}
	
	public UserDTO(User entity, Set<User>following, Set<User> followers) {
		this(entity);
		following.stream().map(x -> this.following.add(new UserDTO(x))).collect(Collectors.toList());
		followers.stream().map(x -> this.followers.add(new UserDTO(x))).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserDTO> getFollowing() {
		return following;
	}

	public Set<UserDTO> getFollowers() {
		return followers;
	}
}
