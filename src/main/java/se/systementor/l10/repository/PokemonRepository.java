package se.systementor.l10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.systementor.l10.domain.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
