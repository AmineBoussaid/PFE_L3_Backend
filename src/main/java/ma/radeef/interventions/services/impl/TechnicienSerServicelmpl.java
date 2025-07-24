package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.TechnicienSerRepository;
import ma.radeef.interventions.models.TechnicienSer;
import ma.radeef.interventions.services.TechnicienSerService;

@Service
@RequiredArgsConstructor
public class TechnicienSerServicelmpl implements TechnicienSerService {

	private final TechnicienSerRepository technicienSerRepository;
	
	@Override
	public void save(TechnicienSer technicienService) {
		technicienSerRepository.save(technicienService);
	}

	@Override
	public List<TechnicienSer> getAll() {
		// TODO Auto-generated method stub
		return technicienSerRepository.findAll();
	}
	
	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
        if (technicienSerRepository.existsById(id)) {
        	technicienSerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
