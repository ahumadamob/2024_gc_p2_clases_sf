package imb.gc.p2.clases.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.gc.p2.clases.entity.Mascota;
import imb.gc.p2.clases.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements IMascotaService {

	@Autowired
	private MascotaRepository repo;
	
	@Override
	public List<Mascota> buscarTodos() {
		return repo.findAll();
	}


}
