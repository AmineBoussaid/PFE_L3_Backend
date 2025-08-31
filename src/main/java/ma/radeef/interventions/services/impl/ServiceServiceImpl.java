package ma.radeef.interventions.services.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.Service;
import ma.radeef.interventions.repositories.ServiceRepository;
import ma.radeef.interventions.services.ServiceService;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
	
    private final ServiceRepository serviceRepository;

	@Override
	public void save(Service service) {
		// TODO Auto-generated method stub
        serviceRepository.save(service);

	}

	@Override
	public Service getById(Long id) {
		// TODO Auto-generated method stub
		return serviceRepository.findById(id).orElse(null);
	}
	
	
	@Override
	public List<Service> getByDepartementId(Long departementId) {
		// TODO Auto-generated method stub
		return serviceRepository.findByDepartementId(departementId);
	}
	

	
	@Override
	public List<Service> getAll() {
		// TODO Auto-generated method stub
        return (List<Service>) serviceRepository.findAll();
	}

	@Override
	public Service getByChefServiceId(Long chefServiceId) {
		// TODO Auto-generated method stub
		return serviceRepository.findByChefServiceId(chefServiceId);
	}



}
