package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.models.Player;
import br.com.codenation.models.Team;
import br.com.codenation.repositories.PlayerRepository;
import br.com.codenation.repositories.TeamRepository;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	private final TeamRepository teamRepo = new TeamRepository();
	private final PlayerRepository playerRepo = new PlayerRepository();

	public void incluirTime(final Long id, final String nome, final LocalDate dataCriacao,
			final String corUniformePrincipal, final String corUniformeSecundario) {
		Team team = teamRepo.findById(id);

		if (team == null) {
			team = new Team(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			teamRepo.save(team);
		} else
			throw new IdentificadorUtilizadoException();
	}

	public void incluirJogador(final Long id, final Long idTime, final String nome, final LocalDate dataNascimento,
			final Integer nivelHabilidade, final BigDecimal salario) {
		final Team team = teamRepo.findById(idTime);
		Player player = playerRepo.findById(id);

		if (team != null) {
			if (player == null) {
				player = new Player(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
				playerRepo.save(player);
			} else
				throw new IdentificadorUtilizadoException();
		} else
			throw new TimeNaoEncontradoException();
	}

	public void definirCapitao(final Long idJogador) {
		final Player player = playerRepo.findById(idJogador);

		if (player == null)
			throw new JogadorNaoEncontradoException();

		final Player capitain = playerRepo.findCaptain(player.getIdTime());
		if (capitain == null) {
			player.setCapitain(true);
		}
	}

	public Long buscarCapitaoDoTime(final Long idTime) {
		final Team team = teamRepo.findById(idTime);

		if (team == null)
			throw new TimeNaoEncontradoException();

		final Player capitain = playerRepo.findCaptain(idTime);
		if (capitain == null) {
			throw new CapitaoNaoInformadoException();
		}

		return capitain.getId();
	}

	public String buscarNomeJogador(final Long idJogador) {
		final Player player = playerRepo.findById(idJogador);

		if (player == null)
			throw new JogadorNaoEncontradoException();

		return player.getNome();
	}

	public String buscarNomeTime(final Long idTime) {
		final Team team = teamRepo.findById(idTime);

		if (team == null)
			throw new TimeNaoEncontradoException();

		return team.getNome();
	}

	public List<Long> buscarJogadoresDoTime(final Long idTime) {
		final Team team = teamRepo.findById(idTime);

		if (team == null)
			throw new TimeNaoEncontradoException();

		return playerRepo.findPlayersByTeam(idTime);
	}

	public Long buscarMelhorJogadorDoTime(final Long idTime) {
		final Team team = teamRepo.findById(idTime);

		if (team == null)
			throw new TimeNaoEncontradoException();

		return playerRepo.findBestPlayer(idTime).getId();
	}

	public Long buscarJogadorMaisVelho(final Long idTime) {
		final Team team = teamRepo.findById(idTime);

		if (team == null)
			throw new TimeNaoEncontradoException();

		return playerRepo.findOlderPlayer(idTime).getId();
	}

	public List<Long> buscarTimes() {
		return teamRepo.findAll();
	}

	public Long buscarJogadorMaiorSalario(final Long idTime) {
		final Team team = teamRepo.findById(idTime);

		if (team == null)
			throw new TimeNaoEncontradoException();

		return playerRepo.findPlayerHighestSalary(idTime).getId();
	}

	public BigDecimal buscarSalarioDoJogador(final Long idJogador) {
		final Player player = playerRepo.findById(idJogador);

		if (player == null)
			throw new JogadorNaoEncontradoException();

		return player.getSalario();
	}

	public List<Long> buscarTopJogadores(final Integer top) {
		return playerRepo.findTopPlayers(top);
	}
}
