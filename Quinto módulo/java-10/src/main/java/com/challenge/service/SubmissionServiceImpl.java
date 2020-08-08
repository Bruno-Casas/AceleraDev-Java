package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface {

	@Autowired
	private SubmissionRepository repository;

	@Override
	public Submission save(Submission object) {
		return repository.save(object);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		BigDecimal higherScore = repository.findHigherScoreByChallengeId(challengeId);

		if (higherScore == null)
			return BigDecimal.ZERO;
		
		return higherScore;
	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
	}
}
