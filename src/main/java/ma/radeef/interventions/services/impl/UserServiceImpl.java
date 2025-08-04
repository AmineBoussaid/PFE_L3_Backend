package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.UserRepository;
import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.services.UserService;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}
	
    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setPassword(null); // Efface le mot de passe pour chaque utilisateur
        }
        return users;
    }
	
    @Override
    public User getById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setPassword(null); // Assurez-vous que la classe User a un setter pour le mot de passe
        }
        return user;
    }
    
	@Override
	public User getByEmail(String email, String password) {
	    User user = userRepository.findByEmail(email);
	    if (user != null && user.getPassword().equals(password)) {
            user.setPassword(null); // Assurez-vous que la classe User a un setter pour le mot de passe
	        return user;
	    }
	    return null; // Retourne null si l'utilisateur n'est pas trouvé ou si le mot de passe est incorrect
	}

	@Override
    public List<TechnicienDto> getTechniciensByServiceId(Long serviceId) {
        return userRepository.findTechniciensByServiceId(serviceId);
    }
	

}
