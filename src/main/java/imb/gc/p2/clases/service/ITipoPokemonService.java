package imb.gc.p2.clases.service;

import java.util.List;

import imb.gc.p2.clases.entity.TipoPokemon;

public interface ITipoPokemonService {
	public List<TipoPokemon>mostrarTodos();
	public TipoPokemon mostrarPorId(Long id);
	public TipoPokemon guardar(TipoPokemon tipoPokemon);
	public void eliminarPorId(Long id);
}
