package com.example.lab8_gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idTipoTicket")
    private TipoTicket idTipoTicket;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private TipoTicket idUsaurio;

}
