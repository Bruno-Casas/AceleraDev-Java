package challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

	@Query(value = "SELECT * FROM SCRIPTS ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
	Quote findRandomQuote();

	@Query(value = "SELECT * FROM SCRIPTS WHERE actor=?1 ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
	Quote findByActor(String actor);

}
