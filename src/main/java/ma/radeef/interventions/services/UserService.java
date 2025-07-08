package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.User;

@Service
public interface UserService {
	
	void save(User user);
	
	List<User> getAll();

}
