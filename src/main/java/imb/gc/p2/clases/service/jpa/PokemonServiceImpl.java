package imb.gc.p2.clases.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import imb.gc.p2.clases.entity.Pokemon;
import imb.gc.p2.clases.repository.PokemonRepository;
import imb.gc.p2.clases.service.IPokemonService;

public class PokemonServiceImpl implements IPokemonService{

	@Autowired
	private PokemonRepository repo;
	
	@Override
	public List<Pokemon> getAll() {
		return repo.findAll();
	}

	@Override
	public Pokemon getById(Long id) {
		Optional<Pokemon> o;
		o = repo.findById(id);
		if(o.isPresent()) {
			return o.get();
		}else {
			return null;
		}
	}

}
