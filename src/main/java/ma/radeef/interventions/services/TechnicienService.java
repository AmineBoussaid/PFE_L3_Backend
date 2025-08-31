package ma.radeef.interventions.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Technicien;

@Service
public interface TechnicienService {
	
	Optional<Technicien> getById(Long id);

	List<Technicien> getByServiceId(Long serviceId);
	
	

}
