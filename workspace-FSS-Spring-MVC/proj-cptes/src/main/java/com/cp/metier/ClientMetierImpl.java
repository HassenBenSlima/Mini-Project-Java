package com.cp.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.dao.ClientRepository;
import com.cp.entities.Client;


@Service //ou component
public class ClientMetierImpl  implements ClientMetier{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public List<Client> clientparMC(String mc) {
		// TODO Auto-generated method stub
		return clientRepository.clientsParMC(mc);
	}

}
