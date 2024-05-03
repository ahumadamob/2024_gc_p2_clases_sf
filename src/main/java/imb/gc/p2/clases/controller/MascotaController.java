package imb.gc.p2.clases.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.gc.p2.clases.entity.Mascota;

@RestController
public class MascotaController {

	@GetMapping("/mascota")
	public Mascota infoDeMiMascota(){
		Mascota mascota = new Mascota();
		mascota.setNombre("Fido");
		mascota.setRaza("Perro");
		mascota.setEdad(3);
		mascota.setPeludo(true);
		return mascota;
	}
}
