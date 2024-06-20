package imb.gc.p2.clases.service;

import java.util.List;

import imb.gc.p2.clases.entity.Pokemon;

public interface IPokemonService {
	public List<Pokemon> getAll();
	public Pokemon getById(Long id);
}
