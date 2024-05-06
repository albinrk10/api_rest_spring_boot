package com.ahm.albin.apirest.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "clientes")
public class Client implements Serializable {
    @Id
    @Column(name ="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "correo")
    private String email;
    @Column(name = "fecha_registro")
    private Date registrationDate ;

}
