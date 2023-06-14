package com.example.lab8_gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tipo_ticket_evento")
public class TipoTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String precio;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;
}
