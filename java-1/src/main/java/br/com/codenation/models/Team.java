package br.com.codenation.models;

import java.time.LocalDate;

public class Team extends BaseEntity{
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;

	public Team(final Long id, final String nome, final LocalDate dataCriacao, final String corUniformePrincipal,
			final String corUniformeSecundario) {
		this.setId(id);
		this.setNome(nome);
		this.dataCriacao = dataCriacao;
		this.corUniformePrincipal = corUniformePrincipal;
		this.corUniformeSecundario = corUniformeSecundario;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(final LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}

	public void setCorUniformePrincipal(final String corUniformePrincipal) {
		this.corUniformePrincipal = corUniformePrincipal;
	}

	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}

	public void setCorUniformeSecundario(final String corUniformeSecundario) {
		this.corUniformeSecundario = corUniformeSecundario;
	}
}