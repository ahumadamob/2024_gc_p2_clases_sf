package imb.gc.p2.clases.service;

import java.util.List;

import imb.gc.p2.clases.entity.Club;

public interface IClubService {
	public List<Club>mostrarTodos();
	public Club mostrarPorId(Long id);
	public Club guardar(Club club);
	public void eliminar(Long id);
	public boolean existe(Long id);

}
