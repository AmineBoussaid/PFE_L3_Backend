package ma.radeef.interventions.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.radeef.interventions.models.Client;
import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.dao.ClientRepository;
import ma.radeef.interventions.services.ClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
	
	private final ClientRepository clientRepository;

	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client getByCodeAbonnement(String codeAbonnement) {
		// TODO Auto-generated method stub
		return clientRepository.findByCodeAbonnement(codeAbonnement);
	}

}
