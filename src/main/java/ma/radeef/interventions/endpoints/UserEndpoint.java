package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.TechnicienDto;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.services.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserEndpoint {
	
	private final UserService userService;
	
	@PostMapping("/add")
	public void add(@RequestBody User user) {
		userService.save(user);
	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public User getById(@PathVariable Long id){
		return userService.getById(id);
	}
	
	@GetMapping("/getTechniciensByServiceId/{serviceId}")
    public List<TechnicienDto> getTechniciensByServiceId(@PathVariable Long serviceId) {
        return userService.getTechniciensByServiceId(serviceId);
    }
	
	@GetMapping("/getByEmail/{email}/{password}")
	public ResponseEntity<User> getByEmail(@PathVariable String email, @PathVariable String password) {
	    User user = userService.getByEmail(email, password);
	    if (user != null) {
	        return ResponseEntity.ok(user);
	    }
	    return ResponseEntity.notFound().build(); // Retourne un statut 401 si non autorisé
	}

}
