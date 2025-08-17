package ma.radeef.interventions.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Client;

@Service
public interface ClientService {
	
	void save(Client client);
	
	List<Client> getAll();
	
	Client getByCodeAbonnement(String codeAbonnement);

}
