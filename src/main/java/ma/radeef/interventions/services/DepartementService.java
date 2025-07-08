package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Departement;

@Service
public interface DepartementService {
	
	void save(Departement departement);
	
	List<Departement> getAll();


}
