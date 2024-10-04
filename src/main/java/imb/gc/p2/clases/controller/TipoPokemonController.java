package imb.gc.p2.clases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import imb.gc.p2.clases.dto.ResponseDTO;
import imb.gc.p2.clases.entity.TipoPokemon;
import imb.gc.p2.clases.service.ITipoPokemonService;

@RestController
public class TipoPokemonController {
	
	@Autowired
	private ITipoPokemonService service;
	
	@GetMapping("/pruebaok")
	public ResponseDTO<?> pruebaOk(){
		ResponseEntity response;
		ResponseDTO<?> dto = new ResponseDTO<>();
		dto.setCode(200);
		dto.setMessage("La prueba salio OK");	
		//response = new ResponseEntity("Prueba OK", HttpStatus.OK);
		//return response;
		return dto;
		
	}
	
	
	@GetMapping("/pruebanotfound")
	public ResponseEntity pruebaNotFound(){
		ResponseEntity response;
		response = new ResponseEntity("Mensaje de prueba para Not Found", HttpStatus.NOT_FOUND);
		return response;
		
	}	
	
	@GetMapping("/tipo")
	public ResponseDTO<List<TipoPokemon>> mostrarTodosLosTiposDePokemones(){
		ResponseDTO<List<TipoPokemon>> dto = new ResponseDTO<>();
		
		List<TipoPokemon> listaTodos;
		listaTodos = service.mostrarTodos();
		if(listaTodos.isEmpty()) {
			dto.setCode(400);
			dto.setMessage("Listado Vacio");
			dto.setData(listaTodos);
			//ResponseEntity response;
			//response = new ResponseEntity(null, HttpStatus.NO_CONTENT );
			//return response;			
		}else {
			dto.setCode(200);
			dto.setMessage("Listado");
			dto.setData(listaTodos);
			//ResponseEntity response;
			//response = new ResponseEntity(listaTodos, HttpStatus.OK );
			//return response;			
		}
		//return listaTodos;
		return dto;
			
		//return service.mostrarTodos();
	}
	
	@GetMapping("/tipo/{id}")
	ResponseDTO<?> mostrarTipoPokemonPorId(@PathVariable("id") Long id){
		
		ResponseDTO<TipoPokemon> dto = new ResponseDTO<>();
		if(service.existe(id)) {
			dto.setCode(200);
			dto.setMessage("Encontrado");
			dto.setData(service.mostrarPorId(id));
			//return new ResponseEntity<TipoPokemon>(service.mostrarPorId(id), HttpStatus.OK );
		}else {
			dto.setCode(404);
			dto.setMessage("No Encontrado");
			//dto.setData(null);
			//return new ResponseEntity<String>("No encontrado", HttpStatus.NOT_FOUND);	
		}
		/*
		TipoPokemon tipoPokemon = service.mostrarPorId(id);
		return tipoPokemon;
		*/
		//return service.mostrarPorId(id);
		return dto;
	}
	
	@PostMapping("/tipo")
	ResponseEntity crearNuevoTipoPokemon(@RequestBody TipoPokemon tipoPokemonDesdeElServicio){
		if(service.existe(tipoPokemonDesdeElServicio.getId())) {
			ResponseEntity response;
			response = new ResponseEntity("Este elemento ya existe", HttpStatus.BAD_REQUEST );
			return response;			
			
		}else {
			ResponseEntity response;
			response = new ResponseEntity(service.guardar(tipoPokemonDesdeElServicio), HttpStatus.CREATED );
			return response;			
			//crear nuevo tipo
		}
		/*
		TipoPokemon tipoPokemonPersistido = service.guardar(tipoPokemonDesdeElServicio);
		return tipoPokemonPersistido;
		*/
		//return service.guardar(tipoPokemonDesdeElServicio);
	}
	
	@PutMapping("/tipo")
	ResponseEntity actualizarTipoNuevoPokemon(@RequestBody TipoPokemon tipoPokemonDesdeElServicio){
		if(service.existe(tipoPokemonDesdeElServicio.getId())) {
			ResponseEntity response;
			response = new ResponseEntity(service.guardar(tipoPokemonDesdeElServicio), HttpStatus.OK );
			return response;
		}else {
			ResponseEntity response;
			response = new ResponseEntity("Este elemento no existe, utilice el POST", HttpStatus.BAD_REQUEST );
			return response;
		}
		/*
		TipoPokemon tipoPokemonPersistido = service.guardar(tipoPokemonDesdeElServicio);
		return tipoPokemonPersistido;
		*/
		//return service.guardar(tipoPokemonDesdeElServicio);
	}
	
	@DeleteMapping("/tipo/{id}")
	ResponseEntity borrarTipoPokemon(@PathVariable("id") Long id){
		if(service.existe(id)) {
			ResponseEntity response;
			service.eliminarPorId(id);
			response = new ResponseEntity("Elemento eliminado", HttpStatus.OK );
			return response;
		}else {
			ResponseEntity response;
			response = new ResponseEntity("Este elemento no existe, No se puede eliminar", HttpStatus.BAD_REQUEST );
			return response;
		}
		//service.eliminarPorId(id);
	}
	

}
