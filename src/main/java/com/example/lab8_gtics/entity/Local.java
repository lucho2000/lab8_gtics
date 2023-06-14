package com.example.lab8_gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String direccion;
    private String latitud;
    private String longitud;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa idEmpresa;
}
