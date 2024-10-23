package imb.gc.p2.clases.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Club {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String ciudad;
	private String categoria;
	private int socios;
	// Este es mi ejemplo de encapsulamiento
	// Como juegaCopa es private, no puedo accederlo
	//  directamente
	private boolean juegaCopa;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getSocios() {
		return socios;
	}
	public void setSocios(int socios) {
		this.socios = socios;
	}
	// Aca hicimos el getter del atributo encapsulado
	public boolean isJuegaCopa() {
		return juegaCopa;
	}
	
	// Aca hicimos el setter del atributo encapsulado
	public void setJuegaCopa(boolean juegaCopa) {
		this.juegaCopa = juegaCopa;
	}
	public Long getId(){
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
