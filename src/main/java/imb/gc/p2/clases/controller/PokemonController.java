package imb.gc.p2.clases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import imb.gc.p2.clases.entity.Pokemon;
import imb.gc.p2.clases.service.IPokemonService;

@RestController
public class PokemonController {
	
	@Autowired
	private IPokemonService service;
	
	@GetMapping("/pokemon")
	public List<Pokemon> obtenerTodosLosPokemones(){
		List<Pokemon> pokemones = service.getAll();
		return pokemones;
	}
	
	@GetMapping("/pokemon/{id}")
	public Pokemon obtenerPokemonPorId(@PathVariable("id") Long id) {
		Pokemon pokemon = service.getById(id);
		return pokemon;
	}
	
	@PostMapping("/pokemon")
	public Pokemon crearPokemon(@RequestBody Pokemon pokemon) {
		return service.save(pokemon);
	}

}
