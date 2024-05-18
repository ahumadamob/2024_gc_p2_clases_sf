package imb.gc.p2.clases.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.gc.p2.clases.entity.Mascota;
import imb.gc.p2.clases.service.IMascotaService;
import imb.gc.p2.clases.service.MascotaService;

@RestController
public class MascotaController {

	// Inyeccion de dependencia
	@Autowired
	private IMascotaService service; 
	
	@GetMapping("/mascota")
	public Mascota infoDeMiMascota(){
		Mascota mascota = new Mascota();
		mascota.setNombre("Fido");
		mascota.setRaza("Perro");
		mascota.setEdad(3);
		mascota.setPeludo(true);
		return mascota;
	}
	
	@GetMapping("/mascotas")
	public List<Mascota>buscarTodasLasMascotas(){
		return service.buscarTodos();

	}
	

}
