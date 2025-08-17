package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.models.User;

@Service
public interface UserService {
	
	void save(User user);
	
	List<User> getAll();
	
	User getById(Long id);
	
	User Login(String email,String password, HttpServletRequest request);
	
	void Logout(HttpServletRequest request);

	List<TechnicienDto>getTechniciensByServiceId(Long serviceId);

}
