package imb.gc.p2.clases.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pokemon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String proxima;
	private String previa;
	private String territorio;
	private int generacion;
	private String tipo;
	private String ataque;
	private String color;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProxima() {
		return proxima;
	}
	public void setProxima(String proxima) {
		this.proxima = proxima;
	}
	public String getPrevia() {
		return previa;
	}
	public void setPrevia(String previa) {
		this.previa = previa;
	}
	public String getTerritorio() {
		return territorio;
	}
	public void setTerritorio(String territorio) {
		this.territorio = territorio;
	}
	public int getGeneracion() {
		return generacion;
	}
	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAtaque() {
		return ataque;
	}
	public void setAtaque(String ataque) {
		this.ataque = ataque;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	

	

}
