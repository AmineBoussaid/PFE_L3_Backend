package ma.radeef.interventions.endpoints;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.radeef.interventions.endpoints.errors.BadRequestException;
import ma.radeef.interventions.endpoints.errors.NotFoundException;
import ma.radeef.interventions.models.Client;
import lombok.RequiredArgsConstructor;
import ma.radeef.interventions.services.ClientService;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientEndpoint {
	
	private final ClientService clientService;
	
	@PostMapping("/add")
	public void add(@RequestBody Client client) {
		clientService.save(client);
	}
	
	@GetMapping("/getAll")
    public List<Client> getAll() {
        return clientService.getAll();
    }
	
    @GetMapping("/getByCodeAbonnement/{codeAbonnement}")
    public Client getByCodeAbonnement(@PathVariable String codeAbonnement) {
    	if(!StringUtils.isNumeric(codeAbonnement))
    		throw new BadRequestException();
        var client = clientService.getByCodeAbonnement(codeAbonnement);
        if(client == null)
        	throw new NotFoundException(String.format("le client avec le code abonnement %s n'existe pas", codeAbonnement));
        return client;
    }
	

}
