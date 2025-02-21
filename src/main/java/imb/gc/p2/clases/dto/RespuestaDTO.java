package imb.gc.p2.clases.dto;

import java.util.ArrayList;
import java.util.List;

public class RespuestaDTO<T> {
	private boolean estado; // true exitoso
	private List<String> mensaje;
	private T data;
	public boolean isEstado() {
		return estado;
	}
	
	
	public RespuestaDTO(boolean estado, List<String> mensaje, T data) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
		this.data = data;
	}
	
	public RespuestaDTO(boolean estado, String mensaje, T data) {
		super();
		List<String> mensajes = new ArrayList();
		mensajes.add(mensaje);
		this.estado = estado;		
		this.mensaje = mensajes;
		this.data = data;
	}
	
	public RespuestaDTO() {
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public List<String> getMensaje() {
		return mensaje;
	}
	public void setMensaje(List<String> mensaje) {
		this.mensaje = mensaje;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
