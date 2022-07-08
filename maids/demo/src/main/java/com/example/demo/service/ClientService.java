package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
@Service
public interface ClientService {
    public List<Client> getAllClients();
    Client saveClient(Client client);
    Client getClientById(Long id);
    Client updateClient(Client client);
    void deleteClientById(Long id);
}
