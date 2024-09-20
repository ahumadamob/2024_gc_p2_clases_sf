package imb.gc.p2.clases.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.gc.p2.clases.entity.TipoPokemon;
import imb.gc.p2.clases.repository.TipoPokemonRepository;
import imb.gc.p2.clases.service.ITipoPokemonService;

@Service
public class TipoPokemonServiceImpl implements ITipoPokemonService {
	@Autowired
	private TipoPokemonRepository repo;

	@Override
	public List<TipoPokemon> mostrarTodos() {
		/*
		List<TipoPokemon> lista = null;
		lista = repo.findAll();
		return lista;
		*/
		return repo.findAll();
	}

	@Override
	public TipoPokemon mostrarPorId(Long id) {
		/*
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
		*/
		return repo.findById(id).orElse(null);
	}

	@Override
	public TipoPokemon guardar(TipoPokemon tipoPokemon) {
		/*
		TipoPokemon tipoPokemonPersistido = null;
		tipoPokemonPersistido = repo.save(tipoPokemon);
		return tipoPokemonPersistido;
		*/
		return repo.save(tipoPokemon);
	}

	@Override
	public void eliminarPorId(Long id) {
		repo.deleteById(id);
		//DELETE FROM TipoPokemon WHERE id = :id
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existe(Long id) {
		if(id == null) {
			return false;
		}else {
			return repo.existsById(id);
		}
		
		// TODO Auto-generated method stub
		//return false;
	}

}
