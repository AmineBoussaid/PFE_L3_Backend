package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Technicien;
import ma.radeef.interventions.models.User;

@Service
public interface UserService extends UserDetailsService {
	
	void save(User user);
	
	List<User> getAll();
	
	User getById(Long id);
		
	List<Technicien> getTechniciensByServiceId(Long serviceId);

	User getByEmail(String email);
	
	User getByUsername(String username);

}
