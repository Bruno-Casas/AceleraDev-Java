package com.challenge.service;

import java.util.List;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeServiceInterface {

	@Autowired
	private ChallengeRepository repository;

	@Override
	public Challenge save(Challenge object) {
		repository.save(object);
		return null;
	}

	@Override
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
		return repository.findByAccelerationsIdAndSubmissionsIdUserId(accelerationId, userId);
	}
}
