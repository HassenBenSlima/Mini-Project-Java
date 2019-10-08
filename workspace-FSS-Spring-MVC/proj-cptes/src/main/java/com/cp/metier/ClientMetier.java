package com.cp.metier;

import java.util.List;

import com.cp.entities.Client;

public interface ClientMetier {
 
	public Client addClient (Client c);
	public List<Client> listClient();
	public List<Client> clientparMC(String mc);
}
