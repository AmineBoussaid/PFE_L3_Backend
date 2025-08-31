package ma.radeef.interventions.endpoints;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.endpoints.dtos.UserDto;
import ma.radeef.interventions.endpoints.dtos.mappers.UserDtoMapper;
import ma.radeef.interventions.models.Technicien;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.services.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserEndpoint {
	
	private final UserService userService;
	private final UserDtoMapper userDtoMapper;

	
	@PostMapping("/add")
	public void add(@RequestBody User user) {
		userService.save(user);
	}
	
	@GetMapping("/getAll")
	public List<UserDto> getAll(){
		return userService.getAll().stream().map(i -> userDtoMapper.toDto(i)).toList();
	}
	
	@GetMapping("/getById/{id}")
	public UserDto getById(@PathVariable Long id){
		
		return userDtoMapper.toDto(userService.getById(id));
	}
	
	@GetMapping("/getTechniciensByServiceId/{serviceId}")
    public List<Technicien> getTechniciensByServiceId(@PathVariable Long serviceId) {
        return userService.getTechniciensByServiceId(serviceId);
    }
	
	@GetMapping("/getByUsername/{username}")
	public ResponseEntity<UserDto> login(@PathVariable String username) {
	    User user = userService.getByUsername(username);
	    if (user != null) {
	    	UserDto userDto = userDtoMapper.toDto(user);
	        return ResponseEntity.ok(userDto);
	    }
	    return ResponseEntity.notFound().build();
	}
	
}
