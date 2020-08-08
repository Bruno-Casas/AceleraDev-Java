package com.challenge.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -8356254476281508664L;
	
	@EmbeddedId
	private SubmissionPK submissionPK;
	
	@NotNull
	@Column(nullable = false)
	private BigDecimal score;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	public SubmissionPK getSubmissionPK() {
		return submissionPK;
	}

	public void setSubmissionPK(SubmissionPK submissionPK) {
		this.submissionPK = submissionPK;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((submissionPK == null) ? 0 : submissionPK.hashCode());
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
		Submission other = (Submission) obj;
		if (submissionPK == null) {
			if (other.submissionPK != null)
				return false;
		} else if (!submissionPK.equals(other.submissionPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Submission [score=" + score + ", created_at=" + createdAt + ",user=" + submissionPK.getUser() + "]";
	}
}
