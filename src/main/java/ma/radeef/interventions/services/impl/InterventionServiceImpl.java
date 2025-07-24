package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.InterventionHistRepository;
import ma.radeef.interventions.dao.InterventionRepository;
import ma.radeef.interventions.endpoints.dtos.mappers.InterventionDtoMapper;
import ma.radeef.interventions.models.Intervention;
import ma.radeef.interventions.models.InterventionHist;
import ma.radeef.interventions.services.InterventionService;

@Service
@RequiredArgsConstructor
public class InterventionServiceImpl implements InterventionService{
	
	private final InterventionRepository interventionRepository;
	private final InterventionDtoMapper interventionDtoMapper;
	private final InterventionHistRepository interventionHistRepository;
	
    public void save(Intervention intervention) {
        if (intervention.getStatus() == null) {
            intervention.setStatus("En cours");
        }
        interventionRepository.save(intervention);
        /*StatusModification.updateReclamationStatus(intervention);*/
        InterventionHist interventionHist = interventionDtoMapper.toDto(intervention);
        interventionHistRepository.save(interventionHist);
    }

	@Override
	public Intervention getById(Long id) {
		// TODO Auto-generated method stub
		return interventionRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Intervention> getAll() {
		// TODO Auto-generated method stub
		return interventionRepository.findAll();
	}

	@Override
	public List<Intervention> getByServiceId(Long serviceId) {
		// TODO Auto-generated method stub
		return interventionRepository.findByServiceId(serviceId);
	}
	
	@Override
	public List<Intervention> getByDepartementId(Long departementId) {
		// TODO Auto-generated method stub
		return interventionRepository.findByDepartementId(departementId);
	}


	
	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
        if (interventionRepository.existsById(id)) {
        	interventionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }



}
