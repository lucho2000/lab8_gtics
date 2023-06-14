package com.example.lab8_gtics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab8_gtics.entity.Evento;
import org.springframework.stereotype.Repository;


@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{
}
