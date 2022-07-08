package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;


@Controller
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        super();
        this.clientService = clientService;
    }


    @GetMapping("/")
    public String listClients(Model model) {
        model.addAttribute("clients",clientService.getAllClients());
        return "clients";
    }


    @GetMapping("/clients/new")
    public String createClientForm(Model model){
        Client client = new Client();
        model.addAttribute("client",client);
        return "create_clients";
    }

    @PostMapping("/")
    public String saveClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return "redirect:/";
    }

    @GetMapping("/clients/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "edit_client";
        
    }

    @PostMapping("/clients/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute("client") Client client, Model model) {

        Client existingClient = clientService.getClientById(id);
        existingClient.setId(id);
        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setMobile(client.getMobile());

        clientService.updateClient(existingClient);
        return "redirect:/";
    }

    @GetMapping("/clients/{id}")
    public String deleteClients(@PathVariable Long id){
        clientService.deleteClientById(id);
        return  "redirect:/";
    }
}
