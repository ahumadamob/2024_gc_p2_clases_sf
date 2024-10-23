package imb.gc.p2.clases.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
			dto.setMensaje("No se encontraron Clubes");
			dto.setData(null);
		}else {
			dto.setEstado(true);
			dto.setMensaje("Se encontraron los siguientes clubes");
			dto.setData(listaClub);
		}		
		return dto;
		
	}
	//	Buscar por ID:
	void buscarPorId(){
		
	}
	//	Crear un nuevo elemento:
	void crearNuevo(){
		
	}
	//Actualizar un elemento existente:
	void actualizar(){
		
	}
	//Eliminar un elemento:
	void eliminar(){
		
	}


}
