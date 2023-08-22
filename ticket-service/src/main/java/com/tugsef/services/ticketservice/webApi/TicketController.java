package com.tugsef.services.ticketservice.webApi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tugsef.services.ticketservice.bussiness.abstracts.TicketService;
import com.tugsef.services.ticketservice.entities.es.TicketModel;

import lombok.AllArgsConstructor;

@RequestMapping("/ticket")
@RestController
@AllArgsConstructor
public class TicketController {

    private  TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketModel> getById(@PathVariable String id) {
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TicketModel> createTicket(@RequestBody TicketModel ticketModel) {
        return ResponseEntity.ok(ticketService.save(ticketModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketModel> updateTicket(@PathVariable String id,
                                                  @RequestBody TicketModel ticketModel) {
        return ResponseEntity.ok(ticketService.update(id, ticketModel));
    }

    @GetMapping
    public ResponseEntity<Page<TicketModel>> getAll(Pageable pageable) {
        return ResponseEntity.ok(ticketService.getPagination(pageable));
    }
}
