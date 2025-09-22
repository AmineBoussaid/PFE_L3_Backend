package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.Technicien;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.repositories.TechnicienRepository;
import ma.radeef.interventions.repositories.UserRepository;
import ma.radeef.interventions.services.UserService;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final TechnicienRepository technicienRepository;
	
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
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    

	@Override
    public List<Technicien> getTechniciensByServiceId(Long serviceId) {
        return technicienRepository.findByServiceId(serviceId);
    }
	

	@Override
	public User getByUsername(String username) {
		return userRepository.findByUsername(username).orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getByUsername(username);
	}

	

}
