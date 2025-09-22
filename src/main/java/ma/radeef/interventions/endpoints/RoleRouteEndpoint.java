package ma.radeef.interventions.endpoints;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.models.User;
import ma.radeef.interventions.services.RoleRouteService;

@RestController
@RequestMapping("/api/role_routes")
@RequiredArgsConstructor
public class RoleRouteEndpoint {
	
    private final RoleRouteService roleRouteService;

    @GetMapping("/check-authorization")
    public boolean checkAuthorization( @AuthenticationPrincipal User user, @RequestParam String route) {
        return roleRouteService.isRouteAuthorized(user.getRole(), route);
    }

}
