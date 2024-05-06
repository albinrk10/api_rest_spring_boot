package com.ahm.albin.apirest.controller;
import com.ahm.albin.apirest.model.dto.ClientDto;
import com.ahm.albin.apirest.model.entity.Client;
import com.ahm.albin.apirest.model.payload.MessageResponse;
import com.ahm.albin.apirest.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private IClientService clientService;

    ///
    @GetMapping("client")
    public ResponseEntity<?> showAll() {
        List<Client> getList= clientService.listAll();

        if (getList == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("No hay registros")
                            .object(null)
                            .build()
                    ,HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Se encontraron registros")
                        .object(getList)
                        .build()
                ,HttpStatus.OK
        );

    }
    //

     @PostMapping("client")
    public ResponseEntity <?>create(@RequestBody ClientDto clientDto){
         Client clientSave = null;
         try {
             clientSave=   clientService.save(clientDto);
             return new ResponseEntity<>(
                     MessageResponse.builder()
                             .message("Guardado Correctamente")
                             .object(ClientDto.builder()
                                     .idClient(clientSave.getIdClient())
                                     .name(clientSave.getName())
                                     .lastName(clientSave.getLastName())
                                     .registrationDate(clientSave.getRegistrationDate())
                                     .email(clientSave.getEmail())
                                     .build())
                             .build()
                        ,HttpStatus.CREATED

             ) ;

         } catch (DataAccessException exDt) {
             return new ResponseEntity<>(MessageResponse.builder()
                     .message(exDt.getMessage())
                     .object(null)
                     .build()
                     ,HttpStatus.METHOD_NOT_ALLOWED);

         }



    }

    @PutMapping("client/{id}")
    public ResponseEntity <?> update(@RequestBody ClientDto  clientDto,@PathVariable Integer id) {
        Client clientUpdate =null;
        try {

            if (clientService.existsById(id)) {
                clientDto.setIdClient(id);
                clientUpdate =clientService.save(clientDto);
                return  new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Actualizado Correctamente")
                                .object(ClientDto.builder()
                                        .idClient(clientUpdate.getIdClient())
                                        .name(clientUpdate.getName())
                                        .lastName(clientUpdate.getLastName())
                                        .registrationDate(clientUpdate.getRegistrationDate())
                                        .email(clientUpdate.getEmail())
                                        .build())
                                .build()
                        ,HttpStatus.CREATED
                );
            }else {
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("No se encontro el cliente, para actualizarlo")
                                .object(null)
                                .build()
                        ,HttpStatus.METHOD_NOT_ALLOWED
                );
            }




        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(exDt.getMessage())
                    .object(null)
                    .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);

        }

    }


    @DeleteMapping("client/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){

         try {
             Client clientDelete =  clientService.findById(id);
             clientService.delete(clientDelete);
             return new ResponseEntity<>(clientDelete,HttpStatus.NO_CONTENT);
            } catch (DataAccessException exDt) {
             return new ResponseEntity<>(MessageResponse.builder()
                     .message(exDt.getMessage())
                     .object(null)
                     .build()
                     ,HttpStatus.METHOD_NOT_ALLOWED);

         }
    }

    @GetMapping("client/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Client client= clientService.findById(id);

         if (client == null) {
             return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("No se encontro el cliente")
                                .object(null)
                                .build()
                        ,HttpStatus.NOT_FOUND
             );
         }
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Cliente encontrado")
                            .object(ClientDto.builder()
                                    .idClient(client.getIdClient())
                                    .name(client.getName())
                                    .lastName(client.getLastName())
                                    .registrationDate(client.getRegistrationDate())
                                    .email(client.getEmail())
                                    .build())
                            .build()
                    ,HttpStatus.OK
            );

    }
}
