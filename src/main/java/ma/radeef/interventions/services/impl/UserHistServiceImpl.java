package ma.radeef.interventions.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.UserHistRepository;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.models.UserHist;
import ma.radeef.interventions.services.UserHistService;

@Service
@RequiredArgsConstructor
public class UserHistServiceImpl implements UserHistService {
	
	private final UserHistRepository userHistRepository;
	
	@Override
	public void save(User user,String action,String details,String ipAddress) {
		// TODO Auto-generated method stub
		UserHist userHist = new UserHist();
		userHist.setUser(user);
		userHist.setAction(action);
		userHist.setDetails(details);
		userHist.setIpAddress(ipAddress);
		userHistRepository.save(userHist);
	}

	@Override
	public List<UserHist> getAll() {
		// TODO Auto-generated method stub
		return userHistRepository.findAll();
	}

	@Override
	public List<UserHist> getByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userHistRepository.findByUserId(userId);
	}

}
