package com.challenge.service;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateServiceInterface {

	@Autowired
	private CandidateRepository repository;

	@Override
	public Candidate save(Candidate object) {
		return repository.save(object);
	}

	@Override
	public Optional<Candidate> findById(CandidateId id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		return repository.findById(userId, companyId, accelerationId);
	}

	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		return repository.findByIdCompanyId(companyId);
	}

	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		return repository.findByIdAccelerationId(accelerationId);
	}
	
}