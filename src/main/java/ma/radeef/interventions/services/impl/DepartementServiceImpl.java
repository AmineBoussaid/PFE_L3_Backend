package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.DepartementRepository;
import ma.radeef.interventions.models.Departement;
import ma.radeef.interventions.services.DepartementService;

@Service
@RequiredArgsConstructor
public class DepartementServiceImpl implements DepartementService{
	
	private final DepartementRepository departementRepository;

	@Override
	public void save(Departement departement) {
		// TODO Auto-generated method stub
		departementRepository.save(departement);
		
	}

	@Override
	public List<Departement> getAll() {
		// TODO Auto-generated method stub
		return departementRepository.findAll();
	}

	@Override
	public Departement getByChefDepartement(Long chefDepartementId) {
		// TODO Auto-generated method stub
		return departementRepository.findByChefDepartementId(chefDepartementId) ;
	}

}
