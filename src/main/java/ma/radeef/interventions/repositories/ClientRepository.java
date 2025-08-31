package ma.radeef.interventions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByCodeAbonnement(String codeAbonnement);
}
