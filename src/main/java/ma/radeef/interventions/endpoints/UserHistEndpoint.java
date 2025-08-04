package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.UserHist;
import ma.radeef.interventions.services.UserHistService;

@RestController
@RequestMapping("/api/users-historique")
@RequiredArgsConstructor
public class UserHistEndpoint {
	
	private final UserHistService userHistService;
	
	@GetMapping("/getAll")
	public List<UserHist> getAll(){
		return userHistService.getAll();
	}
	
	@GetMapping("/getByUserId/{userId}")
	public List<UserHist> getByUserId(@PathVariable Long userId){
		return userHistService.getByUserId(userId);
	}


}
