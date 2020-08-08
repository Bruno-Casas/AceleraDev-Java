package com.challenge.entity;

import java.io.Serializable;
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
public class Candidate implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 2038856192711499217L;
	
	@EmbeddedId
	private CandidatePK candidatePK;

	@NotNull
	@Column(nullable = false)
	private Integer status;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	public CandidatePK getCandidatePK() {
		return candidatePK;
	}

	public void setCandidatePK(CandidatePK candidatePK) {
		this.candidatePK = candidatePK;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
		result = prime * result + ((candidatePK == null) ? 0 : candidatePK.hashCode());
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
		Candidate other = (Candidate) obj;
		if (candidatePK == null) {
			if (other.candidatePK != null)
				return false;
		} else if (!candidatePK.equals(other.candidatePK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candidate [user=" + candidatePK.getUser() + ", " + "acceleration=" + candidatePK.getAcceleration()
				+ "]";
	}
}
