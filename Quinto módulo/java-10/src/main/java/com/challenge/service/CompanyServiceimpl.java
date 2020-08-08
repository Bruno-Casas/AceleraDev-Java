package com.challenge.service;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceimpl implements CompanyServiceInterface {

	@Autowired
	private CompanyRepository repository;

	@Override
	public Company save(Company object) {
		return repository.save(object);
	}

	@Override
	public Optional<Company> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Company> findByAccelerationId(Long accelerationId) {
		return repository.findDistinctByCandidatesIdAccelerationId(accelerationId);
	}

	@Override
	public List<Company> findByUserId(Long userId) {
		return repository.findByCandidatesIdUserId(userId);
	}
}
