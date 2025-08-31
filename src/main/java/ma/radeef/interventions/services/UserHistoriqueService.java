package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.User;
import ma.radeef.interventions.models.UserHistorique;

@Service
public interface UserHistoriqueService {
	
	void save(User user,String action,String details);
	
	List<UserHistorique> getAll();
	
	List<UserHistorique> getByUserId(Long userId);

}
