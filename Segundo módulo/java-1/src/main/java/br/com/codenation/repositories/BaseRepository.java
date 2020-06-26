package br.com.codenation.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.codenation.models.BaseEntity;

public class BaseRepository<T extends BaseEntity> {
	protected List<T> data = new ArrayList<>();

	public List<Long> findAll() {
		return data.stream()
			.map(T::getId)
			.sorted()
			.collect(Collectors.toList());
	}

	public T findById(Long id) {
		Optional<T> instace = data.stream()
			.filter(t -> id.equals(t.getId()))
			.findFirst();

		return instace.isPresent() ? instace.get() : null;
	};

	public void save(T instace) {
		data.add(instace);
	}

	public void update(T instace) {
		final int index = data.indexOf(findById(instace.getId()));
		data.set(index, instace);
	}
}