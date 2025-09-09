package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.UserHistoriqueDto;
import ma.radeef.interventions.endpoints.dtos.mappers.UserHistoriqueMapper;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.services.UserHistoriqueService;

@RestController
@RequestMapping("/api/users-historique")
@RequiredArgsConstructor
public class UserHistoriqueEndpoint {
	
	private final UserHistoriqueService userHistoriqueService;
	private final UserHistoriqueMapper userHistoriqueMapper;
	
	@GetMapping("/getAll")
	public List<UserHistoriqueDto> getAll(){
		return userHistoriqueService.getAll().stream().map(u -> userHistoriqueMapper.toDto(u)).toList();
	}
	
	@GetMapping("/getByUserId")
	public List<UserHistoriqueDto> getByUserId(@AuthenticationPrincipal User user){
		return userHistoriqueService.getByUserId(user.getId()).stream().map(u -> userHistoriqueMapper.toDto(u)).toList();
	}


}
