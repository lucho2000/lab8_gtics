package com.example.lab8_gtics.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private String nombre;
    private String descripcion;

    @Column(name = "path_image")
    private String pathImage;

    @ManyToOne
    @JoinColumn(name = "idLocal")
    private Local local;

}
