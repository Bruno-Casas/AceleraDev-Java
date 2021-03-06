package com.challenge.repository;

import java.util.List;

import com.challenge.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByCandidatesIdAccelerationName(String name);

	List<User> findByCandidatesIdCompanyId(Long companyId);
}
