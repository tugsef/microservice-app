package com.tugsef.services.ticketservice.bussiness.conceretes;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tugsef.services.ticketservice.bussiness.abstracts.TicketService;
import com.tugsef.services.ticketservice.bussiness.response.TicketResponse;
import com.tugsef.services.ticketservice.dataAccess.TicketRepository;
import com.tugsef.services.ticketservice.dataAccess.es.TicketElasticRepository;
import com.tugsef.services.ticketservice.entities.PriorityType;
import com.tugsef.services.ticketservice.entities.Ticket;
import com.tugsef.services.ticketservice.entities.TicketStatus;
import com.tugsef.services.ticketservice.entities.es.TicketModel;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketManager implements TicketService {

    private  TicketElasticRepository ticketElasticRepository;
    private  TicketRepository ticketRepository;
  

    @Override
    @Transactional
    public TicketResponse save(TicketResponse ticketResponse) {
        // Ticket Entity
        Ticket ticket = new Ticket();
        //TODO Account API dan dogrula
        // ticket.setAssignee();

        if (ticketResponse.getDescription() == null)
            throw new IllegalArgumentException("Description bos olamaz");

        ticket.setDescription(ticketResponse.getDescription());
        ticket.setNotes(ticketResponse.getNotes());
        ticket.setTicketDate(ticketResponse.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketResponse.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketResponse.getPriorityType()));

        // mysql kaydet
        ticket = ticketRepository.save(ticket);


        // TicketModel nesnesi yarat
        TicketModel model = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();

        // elastic kaydet
        ticketElasticRepository.save(model);

        // olusan nesneyi döndür
        ticketResponse.setId(ticket.getId());
        return ticketResponse;
    }

    @Override
    public TicketResponse update(String id, TicketResponse ticketResponse) {
        return null;
    }

    @Override
    public TicketResponse getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketResponse> getPagination(Pageable pageable) {
        return null;
    }
}