package com.ahm.albin.apirest.service;

import com.ahm.albin.apirest.model.dto.ClientDto;
import com.ahm.albin.apirest.model.entity.Client;

import java.util.List;

public interface IClientService {

    List<Client> listAll();

    Client save(ClientDto client);

    Client findById(Integer id);

     void delete(Client client);

    boolean existsById(Integer id);

   
}
