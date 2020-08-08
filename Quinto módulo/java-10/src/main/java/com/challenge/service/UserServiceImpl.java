package com.challenge.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserRepository repository;

	@Override
	public User save(User object) {
		object.setCreatedAt(LocalDateTime.now());
		return repository.save(object);
	}

	@Override
	public Optional<User> findById(Long userId) {
		return repository.findById(userId);
	}

	@Override
	public List<User> findByAccelerationName(String name) {
		return repository.findByCandidatesIdAccelerationName(name);
	}

	@Override
	public List<User> findByCompanyId(Long companyId) {
		return repository.findByCandidatesIdCompanyId(companyId);
	}
}
