package com.cedrus.TicketingService.repository;

import com.cedrus.TicketingService.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, String> {

}
