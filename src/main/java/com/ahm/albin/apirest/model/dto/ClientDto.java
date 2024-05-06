package com.ahm.albin.apirest.model.dto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


//@AllArgsConstructor //nova
//@NoArgsConstructor
@Data
@ToString
@Builder //patron de diseño para enviar datos en ves de iusar contrucutores
public class ClientDto implements Serializable {

    private Integer idClient;

    private String name;

    private String lastName;

    private String email;

    private Date registrationDate ;

}
