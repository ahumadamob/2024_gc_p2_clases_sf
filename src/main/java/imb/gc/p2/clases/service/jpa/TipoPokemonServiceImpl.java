package imb.gc.p2.clases.service.jpa;

import java.util.List;
import java.util.Optional;

import imb.gc.p2.clases.entity.TipoPokemon;
import imb.gc.p2.clases.repository.TipoPokemonRepository;
import imb.gc.p2.clases.service.ITipoPokemonService;

public class TipoPokemonServiceImpl implements ITipoPokemonService {
	
	private TipoPokemonRepository repo;

	@Override
	public List<TipoPokemon> mostrarTodos() {
		List<TipoPokemon> lista = null;
		lista = repo.findAll();
		return lista;
	}

	@Override
	public TipoPokemon mostrarPorId(Long id) {
		TipoPokemon tipoPokemon = null;
		Optional<TipoPokemon> optional = null;
		optional = repo.findById(id);
		if(optional.isPresent()) {
			tipoPokemon = optional.get();
		}else {
			tipoPokemon = null;
		}
		// TODO Auto-generated method stub
		return tipoPokemon;
	}

	@Override
	public TipoPokemon guardar(TipoPokemon tipoPokemon) {
		TipoPokemon tipoPokemonPersistido = null;
		tipoPokemonPersistido = repo.save(tipoPokemon);
		return tipoPokemonPersistido;
	}

	@Override
	public void eliminarPorId(Long id) {
		repo.deleteById(id);
		//DELETE FROM TipoPokemon WHERE id = :id
		// TODO Auto-generated method stub
		
	}

}
