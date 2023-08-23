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
import com.tugsef.services.ticketservice.bussiness.response.TicketResponse;

import lombok.AllArgsConstructor;

@RequestMapping("/ticket")
@RestController
@AllArgsConstructor
public class TicketController {

    private  TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TicketResponse> createTicket(@RequestBody TicketResponse ticketResponse) {
        return ResponseEntity.ok(ticketService.save(ticketResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketResponse> updateTicket(@PathVariable String id,
                                                  @RequestBody TicketResponse ticketResponse) {
        return ResponseEntity.ok(ticketService.update(id, ticketResponse));
    }

    @GetMapping
    public ResponseEntity<Page<TicketResponse>> getAll(Pageable pageable) {
        return ResponseEntity.ok(ticketService.getPagination(pageable));
    }
}
