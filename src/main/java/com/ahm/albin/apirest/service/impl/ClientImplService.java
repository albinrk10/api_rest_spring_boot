package com.ahm.albin.apirest.service.impl;
import com.ahm.albin.apirest.model.dao.ClientDao;
import com.ahm.albin.apirest.model.dto.ClientDto;
import com.ahm.albin.apirest.model.entity.Client;
import com.ahm.albin.apirest.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientImplService implements IClientService {

    //Inyectamos la dependencia
    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Client> listAll() {
        return (List) clientDao.findAll();
    }

    @Transactional
    @Override
    public Client save(ClientDto clientDto) {
        Client client =  Client.builder()
                .idClient(clientDto.getIdClient())
                .name(clientDto.getName())
                .lastName(clientDto.getLastName())
                .registrationDate(clientDto.getRegistrationDate())
                .email(clientDto.getEmail())
                .build();


        return clientDao.save(client);
    }

    @Transactional(readOnly = true)
    @Override
    public Client findById(Integer id) {
        return clientDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Client client) {

      clientDao.delete(client);
    }

    @Override
    public boolean existsById(Integer id) {
        return clientDao.existsById(id);
    }
}
