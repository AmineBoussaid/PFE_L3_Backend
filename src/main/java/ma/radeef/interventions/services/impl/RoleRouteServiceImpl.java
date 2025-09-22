package ma.radeef.interventions.services.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.repositories.RoleRouteRepository;
import ma.radeef.interventions.services.RoleRouteService;

@Service
@RequiredArgsConstructor
public class RoleRouteServiceImpl implements RoleRouteService {
	
	private final RoleRouteRepository roleRouteRepository;
	   
	@Override
	public boolean isRouteAuthorized(String role, String route) {
		// TODO Auto-generated method stub
        return roleRouteRepository.existsByRoleAndRoute(role, route);
	}
	
	

}
