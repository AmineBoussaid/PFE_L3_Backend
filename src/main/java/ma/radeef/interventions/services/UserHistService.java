package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.User;
import ma.radeef.interventions.models.UserHist;

@Service
public interface UserHistService {
	
	void save(User user,String action,String details,String ipAddress);
	
	List<UserHist> getAll();
	
	List<UserHist> getByUserId(Long userId);

}
