package ma.radeef.interventions.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.ServiceDRepository;
import ma.radeef.interventions.dao.TechnicienSerRepository;
import ma.radeef.interventions.models.ServiceD;
import ma.radeef.interventions.models.TechnicienSer;
import ma.radeef.interventions.services.TechnicienSerService;

@Service
@RequiredArgsConstructor
public class TechnicienSerServicelmpl implements TechnicienSerService {

	private final TechnicienSerRepository technicienSerRepository;
	private final ServiceDRepository serviceDRepository;

	
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

	@Override
	public Optional<ServiceD> getServiceByTechnicienId(Long technicienId) {
		// TODO Auto-generated method stub
		TechnicienSer technicienSer = technicienSerRepository.findByTechnicienId(technicienId);
		return serviceDRepository.findById(technicienSer.getService().getId())
;
	}

	@Override
	public boolean deleteByTechnicienService(Long technicienId, Long serviceId) {
		// TODO Auto-generated method stub
		TechnicienSer technicienSer =  technicienSerRepository.findByTechnicienIdAndServiceId(technicienId, serviceId);
		if(technicienSer != null) {
			technicienSerRepository.deleteById(technicienSer.getId());
			return true;
		}
		return false;
	}




}
