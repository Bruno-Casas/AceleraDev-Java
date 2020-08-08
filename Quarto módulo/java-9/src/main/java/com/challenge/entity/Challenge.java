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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Challenge implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -2307568544237759817L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String name;

	@NotNull
	@NotBlank
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String slug;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@OneToMany(mappedBy = "challenge")
	private Set<Acceleration> accelerations;

	@OneToMany(mappedBy = "submissionPK.challenge")
	private Set<Submission> submissions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Set<Acceleration> getAccelerations() {
		return accelerations;
	}

	public void setAccelerations(Set<Acceleration> accelerations) {
		this.accelerations = accelerations;
	}

	public Set<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(Set<Submission> submissions) {
		this.submissions = submissions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Challenge other = (Challenge) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Challenge [id=" + id + ", name=" + name + "]";
	}
}
