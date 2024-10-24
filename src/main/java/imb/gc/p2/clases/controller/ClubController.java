package imb.gc.p2.clases.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.gc.p2.clases.dto.RespuestaDTO;
import imb.gc.p2.clases.entity.Club;
import imb.gc.p2.clases.service.IClubService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClubController {
	
	@Autowired
	private IClubService service;
	
	//Buscar todos los elementos:
	@GetMapping("/clubes")
	public RespuestaDTO<List<Club>> buscarTodos(){
		List<Club> listaClub;
		listaClub = new ArrayList();
		listaClub = service.mostrarTodos();
		
		RespuestaDTO<List<Club>> dto;
		dto = new RespuestaDTO<List<Club>>();		
		
		if(listaClub.isEmpty()) {
			dto.setEstado(false);
			List<String> mensajes = new ArrayList();
			mensajes.add("No se encontraron Clubes");
			dto.setMensaje(mensajes);
			dto.setData(null);
		}else {
			List<String> mensajes = new ArrayList();
			mensajes.add("Se encontraron los siguientes clubes");
			mensajes.add("Porque todo salio bien");
			dto.setEstado(true);
			dto.setMensaje(mensajes);
			dto.setData(listaClub);
		}		
		return dto;
		
	}
	//	Buscar por ID:
	@GetMapping("/clubes/{id}")
	public RespuestaDTO<Club> buscarPorId(@PathVariable("id") Long id){
		if(service.existe(id)) {
			Club club = new Club();
			club = service.mostrarPorId(id);
			RespuestaDTO<Club> dto;
			dto = new RespuestaDTO<Club>(true, "OK", club);
			return dto;
		}else {			
			return new RespuestaDTO<Club>(false, "No existen club con el id ", null);
		}
		
		
	}
	//	Crear un nuevo elemento:
	@PostMapping("/clubes")
	public RespuestaDTO<Club> crearNuevo(@RequestBody Club clubDesdeElPostman){
		if(service.existe(clubDesdeElPostman.getId())) {
			return new RespuestaDTO<Club>(false, "Este ID ya existe", null);
		}else {
			return new RespuestaDTO<Club>(true, "Club creado con exito", service.guardar(clubDesdeElPostman));
		}
		
	}
	//Actualizar un elemento existente:
	@PutMapping("/clubes")
	public RespuestaDTO<Club> actualizar(@RequestBody Club clubDesdeElPostman){
		if(service.existe(clubDesdeElPostman.getId())) {
			return new RespuestaDTO<Club>(true, "Club actualizado con exito", service.guardar(clubDesdeElPostman));
		}else {
			return new RespuestaDTO<Club>(false, "No se encontró el ID" + clubDesdeElPostman.getId().toString(), null);
		}		
	}
	//Eliminar un elemento:
	@DeleteMapping("/clubes/{ideliminar}")
	public RespuestaDTO<?> eliminar(@PathVariable("ideliminar") Long id){
		if(service.existe(id)) {
			service.eliminar(id);
			return new RespuestaDTO<>(true, "Elemento eliminado el ID: " + id.toString(), null);
		}else {
			return new RespuestaDTO<>(false, "No se encontró el ID" + id.toString(), null);
		}
		
	}


}
