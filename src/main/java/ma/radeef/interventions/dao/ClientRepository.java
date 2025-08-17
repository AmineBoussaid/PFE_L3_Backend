package ma.radeef.interventions.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.radeef.interventions.models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

	List<Client> findAll();

    Client findByCodeAbonnement(String codeAbonnement);
}
