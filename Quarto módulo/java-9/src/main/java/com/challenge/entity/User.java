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

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(final String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final Date createdAt) {
		this.createdAt = createdAt;
	}

	public Set<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(Set<Submission> submissions) {
		this.submissions = submissions;
	}

	public Set<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [full_name=" + fullName + ", id=" + id + ", nickname=" + nickname + "]";
	}
}
