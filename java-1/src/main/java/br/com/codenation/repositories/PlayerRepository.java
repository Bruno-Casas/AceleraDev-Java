package br.com.codenation.repositories;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.codenation.models.Player;

public class PlayerRepository extends BaseRepository<Player> {
	public Player findCaptain(final Long teamId) {
		final Optional<Player> capitain = data.stream().filter(p -> p.isCapitain() & teamId.equals(p.getIdTime()))
				.findFirst();

		return capitain.isPresent() ? capitain.get() : null;
	}

	public List<Long> findPlayersByTeam(final Long teamId) {
		return data.stream().filter(p -> teamId.equals(p.getIdTime())).map(Player::getId).sorted()
				.collect(Collectors.toList());
	}

	public Player findBestPlayer(final Long teamId) {
		return data.stream().filter(p -> teamId.equals(p.getIdTime()))
				.max(Comparator.comparing(Player::getNivelHabilidade)).get();
	}

	public Player findOlderPlayer(final Long teamId) {
		return data.stream().filter(p -> teamId.equals(p.getIdTime()))
				.min(Comparator.comparing(Player::getDataNascimento)).get();
	}

	public Player findPlayerHighestSalary(final Long teamId) {
		return data.stream().filter(p -> teamId.equals(p.getIdTime())).max(Comparator.comparing(Player::getSalario))
				.get();
	}

	public List<Long> findTopPlayers(final Integer tops) {
		return data.stream()
			.sorted(Comparator.comparing(Player::getNivelHabilidade).reversed())
			.limit(tops)
			.map(Player::getId)
			.collect(Collectors.toList());
	}
}