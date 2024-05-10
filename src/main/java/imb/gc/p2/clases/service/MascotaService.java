package imb.gc.p2.clases.service;

import java.util.ArrayList;
import java.util.List;

import imb.gc.p2.clases.entity.Mascota;

public class MascotaService {
	
	public List<Mascota>getTresMascotas() {
		List<Mascota> lstMascota = new ArrayList<Mascota>();
		
		Mascota mascota1 = new Mascota();
		mascota1.setNombre("Fido");
		mascota1.setRaza("Perro");
		mascota1.setEdad(3);
		mascota1.setPeludo(true);
		
		Mascota mascota2 = new Mascota();		
		mascota2.setNombre("Michi");
		mascota2.setRaza("Gato");
		mascota2.setEdad(1);
		mascota2.setPeludo(true);		
		
		Mascota mascota3 = new Mascota();		
		mascota3.setNombre("Pedro");
		mascota3.setRaza("Pez");
		mascota3.setEdad(2);
		mascota3.setPeludo(false);
		
		lstMascota.add(mascota1);
		lstMascota.add(mascota2);
		lstMascota.add(mascota3);
		
		return lstMascota;		
	}
}
