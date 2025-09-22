package ma.radeef.interventions.services;

import org.springframework.stereotype.Service;

@Service
public interface RoleRouteService {
	
	public boolean isRouteAuthorized(String role, String route);

}
