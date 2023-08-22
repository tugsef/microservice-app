package com.tugsef.services.ticketservice.bussiness.conceretes;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tugsef.services.ticketservice.bussiness.abstracts.TicketNotificationService;
import com.tugsef.services.ticketservice.bussiness.abstracts.TicketService;
import com.tugsef.services.ticketservice.dataAccess.TicketRepository;
import com.tugsef.services.ticketservice.dataAccess.es.TicketElasticRepository;
import com.tugsef.services.ticketservice.entities.PriorityType;
import com.tugsef.services.ticketservice.entities.Ticket;
import com.tugsef.services.ticketservice.entities.TicketStatus;
import com.tugsef.services.ticketservice.entities.es.TicketModel;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TicketManager implements TicketService {

    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final TicketNotificationService ticketNotificationService;
    private final AccountServiceClient accountServiceClient;

    @Override
    @Transactional
    public TicketModel save(TicketModel ticketModel) {
        // Ticket Entity
        if (ticketModel.getDescription() == null)
            throw new IllegalArgumentException("Description bos olamaz");

        Ticket ticket = new Ticket();
        ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.get(ticketModel.getAssignee());

        ticket.setDescription(ticketModel.getDescription());
        ticket.setNotes(ticketModel.getNotes());
        ticket.setTicketDate(ticketModel.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketModel.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketModel.getPriorityType()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());

        // mysql kaydet
        ticket = ticketRepository.save(ticket);


        // TicketModel nesnesi yarat
        TicketModel model = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .assignee(accountDtoResponseEntity.getBody().getNameSurname())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();

        // elastic kaydet
        ticketElasticRepository.save(model);

        // olusan nesneyi döndür
        ticketModel.setId(ticket.getId());

        // Kuyruga notification yaz
        ticketNotificationService.sendToQueue(ticket);
        return ticketModel;
    }

    @Override
    public TicketModel update(String id, TicketModel ticketDto) {
        return null;
    }

    @Override
    public TicketModel getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketModel> getPagination(Pageable pageable) {
        return null;
    }
}
