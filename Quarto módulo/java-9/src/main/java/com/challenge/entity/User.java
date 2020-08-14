package com.challenge.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -270997411038847030L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(max = 100)
	@Column(name = "full_name", nullable = false, length = 100)
	private String fullName;

	@NotNull
	@NotBlank
	@Email
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String email;

	@NotNull
	@NotBlank
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String nickname;

	@NotNull
	@NotBlank
	@Size(max = 255)
	@Column(nullable = false)
	private String password;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@OneToMany(mappedBy = "submissionPK.user")
	private Set<Submission> submissions;

	@OneToMany(mappedBy = "candidatePK.user")
	private Set<Candidate> candidates;

}
