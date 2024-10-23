package imb.gc.p2.clases.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.gc.p2.clases.entity.Club;
import imb.gc.p2.clases.repository.ClubRepository;
import imb.gc.p2.clases.service.IClubService;

@Service
public class ClubServiceImpl implements IClubService{
	
	@Autowired
	private ClubRepository repo;

	@Override
	public List<Club> mostrarTodos() {
		return repo.findAll();
	}

	@Override
	public Club mostrarPorId(Long id) {
		Optional<Club> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	@Override
	public Club guardar(Club club) {
		return repo.save(club);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);		
	}

	@Override
	public boolean existe(Long id) {
		if(id == null) {
			return false;
		}else {
			return repo.existsById(id);
		}
	}

}
