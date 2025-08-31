package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.models.UserHistorique;
import ma.radeef.interventions.repositories.UserHistoriqueRepository;
import ma.radeef.interventions.services.UserHistoriqueService;

@Service
@RequiredArgsConstructor
public class UserHistoriqueServiceImpl implements UserHistoriqueService {
	
	private final UserHistoriqueRepository userHistoriqueRepository;
	
	@Override
	public void save(User user,String action,String details) {
		
		UserHistorique userHistorique = new UserHistorique();
		userHistorique.setUser(user);
		userHistorique.setAction(action);
		userHistorique.setDetails(details);
		
		userHistoriqueRepository.save(userHistorique);
	}

	@Override
	public List<UserHistorique> getAll() {
		// TODO Auto-generated method stub
		return userHistoriqueRepository.findAll();
	}

	@Override
	public List<UserHistorique> getByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userHistoriqueRepository.findByUserId(userId);
	}

}
