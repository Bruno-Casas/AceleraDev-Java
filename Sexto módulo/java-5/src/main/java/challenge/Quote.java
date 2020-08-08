package challenge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scripts")
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	@Lob
	private String actor;

	@Column(name = "detail")
	@Lob
	private String quote;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getQuote() {
		return this.quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

}