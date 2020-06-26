package br.com.codenation.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player extends BaseEntity{
	private Long idTime;
	private LocalDate dataNascimento;
	private Integer nivelHabilidade;
	private boolean capitain = false;
	private BigDecimal salario;

	public Player(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {
		this.setId(id);
		this.setNome(nome);
		this.idTime = idTime;
		this.dataNascimento = dataNascimento;
		this.nivelHabilidade = nivelHabilidade;
		this.salario = salario;
	}

	public Long getIdTime() {
		return idTime;
	}

	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getNivelHabilidade() {
		return nivelHabilidade;
	}

	public void setNivelHabilidade(Integer nivelHabilidade) {
		this.nivelHabilidade = nivelHabilidade;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public boolean isCapitain() {
		return capitain;
	}

	public void setCapitain(boolean capitao) {
		this.capitain = capitao;
	}
}