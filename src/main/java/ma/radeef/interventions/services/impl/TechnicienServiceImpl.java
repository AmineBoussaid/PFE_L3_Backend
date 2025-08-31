package ma.radeef.interventions.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.Technicien;
import ma.radeef.interventions.repositories.TechnicienRepository;
import ma.radeef.interventions.services.TechnicienService;

@Service
@RequiredArgsConstructor
public class TechnicienServiceImpl implements TechnicienService{
	
	private final TechnicienRepository technicienRepository;
	
	@Override
	public Optional<Technicien> getById(Long id) {
		// TODO Auto-generated method stub
		return technicienRepository.findById(id);
	}

	@Override
	public List<Technicien> getByServiceId(Long serviceId) {
		// TODO Auto-generated method stub
		return technicienRepository.findByServiceId(serviceId);
	}


	
	

}
