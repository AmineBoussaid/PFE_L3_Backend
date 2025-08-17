package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.ServiceDRepository;
import ma.radeef.interventions.models.ServiceD;
import ma.radeef.interventions.services.ServiceDService;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceDService {
	
    private final ServiceDRepository serviceRepository;

	@Override
	public void save(ServiceD serviceD) {
		// TODO Auto-generated method stub
        serviceRepository.save(serviceD);

	}

	@Override
	public ServiceD getById(Long id) {
		// TODO Auto-generated method stub
		return serviceRepository.findById(id).orElse(null);
	}
	
	
	@Override
	public List<ServiceD> getByDepartementId(Long departementId) {
		// TODO Auto-generated method stub
		return serviceRepository.findByDepartementId(departementId);
	}
	

	
	@Override
	public List<ServiceD> getAll() {
		// TODO Auto-generated method stub
        return (List<ServiceD>) serviceRepository.findAll();
	}

	@Override
	public ServiceD getByChefServiceId(Long chefServiceId) {
		// TODO Auto-generated method stub
		return serviceRepository.findByChefServiceId(chefServiceId);
	}



}
