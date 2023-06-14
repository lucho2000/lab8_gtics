package com.example.lab8_gtics.repository;

import com.example.lab8_gtics.entity.TipoTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTicketRepository extends JpaRepository<TipoTicket, Integer> {
}
