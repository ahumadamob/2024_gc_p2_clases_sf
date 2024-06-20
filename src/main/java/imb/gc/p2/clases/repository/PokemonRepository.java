package imb.gc.p2.clases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.gc.p2.clases.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
