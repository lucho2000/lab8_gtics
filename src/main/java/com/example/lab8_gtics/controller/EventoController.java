package com.example.lab8_gtics.controller;


import com.example.lab8_gtics.entity.Evento;
import com.example.lab8_gtics.repository.EventoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class EventoController {


    final EventoRepository eventoRepository;

    public EventoController(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @GetMapping("/evento")
    public List<Evento> listarEventos(Model model) {
        //model.addAttribute("listaEventos", eventoDao.listarEventos());
        return eventoRepository.findAll();
    }


    @GetMapping("/evento/{id}")
    public ResponseEntity<HashMap<String,Object>> obtenerEventoPorId(
            @PathVariable("id") String idStr) {

        HashMap<String,Object> responseJson = new HashMap<>();

        try {
            int id = Integer.parseInt(idStr);
            Optional<Evento> optProduct = eventoRepository.findById(id);
            if (optProduct.isPresent()) {
                responseJson.put("resultado","exitoso");
                responseJson.put("evento",optProduct.get());
                return ResponseEntity.ok(responseJson);
            } else {
                responseJson.put("msg","evento no encontrado");
            }
        } catch (NumberFormatException e) {
            responseJson.put("msg","el ID debe ser un número entero positivo");
        }
        responseJson.put("resultado","falla");
        return ResponseEntity.badRequest().body(responseJson);
    }



    @PostMapping("/evento")
    public ResponseEntity<HashMap<String, Object>> guardarEvento(
            @RequestBody Evento evento,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        eventoRepository.save(evento);
        if(fetchId){
            responseJson.put("id",evento.getId());
        }
        responseJson.put("estado","creado");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }



    @GetMapping("/eventoConTipoDeTicket/{id}")
    public ResponseEntity<HashMap<String,Object>> obtenerEventoConTipoDeTicketPorId(
            @PathVariable("id") String idStr) {

        HashMap<String,Object> responseJson = new HashMap<>();

        try {
            int id = Integer.parseInt(idStr);
            Optional<Evento> optProduct = eventoRepository.findById(id);
            if (optProduct.isPresent()) {
                responseJson.put("resultado","exitoso");
                responseJson.put("evento",optProduct.get());
                return ResponseEntity.ok(responseJson);
            } else {
                responseJson.put("msg","evento no encontrado");
            }
        } catch (NumberFormatException e) {
            responseJson.put("msg","el ID debe ser un número entero positivo");
        }
        responseJson.put("resultado","falla");
        return ResponseEntity.badRequest().body(responseJson);
    }




}
