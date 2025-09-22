package ma.radeef.interventions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.radeef.interventions.models.RoleRoute;

public interface RoleRouteRepository extends JpaRepository<RoleRoute, Long>  {

    boolean existsByRoleAndRoute(String role, String route);

}
