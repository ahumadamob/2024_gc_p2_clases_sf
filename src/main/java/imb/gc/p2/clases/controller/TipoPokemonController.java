package imb.gc.p2.clases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import imb.gc.p2.clases.entity.TipoPokemon;
import imb.gc.p2.clases.service.ITipoPokemonService;

@RestController
public class TipoPokemonController {
	
	@Autowired
	private ITipoPokemonService service;
	
	@GetMapping("/tipo")
	public List<TipoPokemon> mostrarTodosLosTiposDePokemones(){
		/*
		List<TipoPokemon> listaTodos;
		listaTodos = service.mostrarTodos();		
		return listaTodos;
		*/	
		return service.mostrarTodos();
	}
	
	@GetMapping("/tipo/{id}")
	TipoPokemon mostrarTipoPokemonPorId(@PathVariable("id") Long id){
		/*
		TipoPokemon tipoPokemon = service.mostrarPorId(id);
		return tipoPokemon;
		*/
		return service.mostrarPorId(id);
	}
	
	@PostMapping("/tipo")
	TipoPokemon crearNuevoPokemon(@RequestBody TipoPokemon tipoPokemonDesdeElServicio){
		/*
		TipoPokemon tipoPokemonPersistido = service.guardar(tipoPokemonDesdeElServicio);
		return tipoPokemonPersistido;
		*/
		return service.guardar(tipoPokemonDesdeElServicio);
	}
	
	@PutMapping("/tipo")
	TipoPokemon actualizarNuevoPokemon(@RequestBody TipoPokemon tipoPokemonDesdeElServicio){
		/*
		TipoPokemon tipoPokemonPersistido = service.guardar(tipoPokemonDesdeElServicio);
		return tipoPokemonPersistido;
		*/
		return service.guardar(tipoPokemonDesdeElServicio);
	}
	
	@DeleteMapping("/tipo/{id}")
	void borrarTipoPokemon(@PathVariable("id") Long id){
		service.eliminarPorId(id);
	}
	

}
