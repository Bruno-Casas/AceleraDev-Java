package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

	@Query("from Candidate c where c.id.user = ?1 "
		+ "and c.id.company = ?2 "
		+ "and c.id.acceleration = $3")
	Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

	List<Candidate> findByIdCompanyId(Long companyId);

	List<Candidate> findByIdAccelerationId(Long accelerationId);
}