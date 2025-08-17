package ma.radeef.interventions.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.UserRepository;
import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.services.UserHistService;
import ma.radeef.interventions.services.UserService;
import ma.radeef.interventions.services.utils.GestionHistorique;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final UserHistService userHistService;
    static User user = new User();


	
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
    public List<TechnicienDto> getTechniciensByServiceId(Long serviceId) {
        return userRepository.findTechniciensByServiceId(serviceId);
    }
	
	
	@Override
	public User Login(String email, String password ,HttpServletRequest request) {
	    user = userRepository.findByEmail(email);
	    if (user != null && user.getPassword().equals(password)) {
	    	
            user.setLast_login(new Date());
            GestionHistorique.loginUser(userHistService, user, request);;
            userRepository.save(user); // Enregistrer l'utilisateur mis à jour
            user.setPassword(null); // Assurez-vous que la classe User a un setter pour le mot de passe

            return user;
	    }
	    
	    return null; // Retourne null si l'utilisateur n'est pas trouvé ou si le mot de passe est incorrect
	}


	@Override
	public void Logout(HttpServletRequest request) {
		// TODO Auto-generated method stub
		 if (user != null) {
			 GestionHistorique.logoutUser(userHistService, user, request);;
		 }
	}
	

}
