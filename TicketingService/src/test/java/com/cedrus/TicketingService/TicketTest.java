package com.cedrus.TicketingService;

import com.cedrus.TicketingService.model.Floor;
import com.cedrus.TicketingService.model.Spot;
import com.cedrus.TicketingService.model.Ticket;
import com.cedrus.TicketingService.repository.TicketRepository;
import com.cedrus.TicketingService.request.CreateTicketRequest;
import com.cedrus.TicketingService.response.CreatedTicketResponse;
import com.cedrus.TicketingService.service.SpotService;
import com.cedrus.TicketingService.service.TicketService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TicketTest {

    public static Ticket ticket;

    public static Spot spot;

    public static Floor floor;

    @InjectMocks
    private TicketService ticketService;

    @Mock
    private SpotService spotService;

    @Mock
    private TicketRepository ticketRepository;


    @BeforeAll
    public void setupTicket() {
        floor = new Floor(UUID.randomUUID().toString(), 1, 40);
        spot = new Spot(UUID.randomUUID().toString(), floor, "Compact", true);
        ticket = new Ticket(UUID.randomUUID().toString(), spot, LocalDateTime.now(), null, null);
    }

    @Test
    public void createTicket() {
        when(spotService.bookSpot(any(String.class))).thenReturn(spot);
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);
        CreatedTicketResponse createdTicket = ticketService.createTicket(new CreateTicketRequest("Compact"));
        assertThat(createdTicket.getBookedSpot().getSpotId()).isEqualTo(spot.getSpotId());
        assertThat(createdTicket.getEntranceTimestamp()).isNotNull();
        assertThat(createdTicket.getTicketId()).isEqualTo(ticket.getTicketId());
    }

    @Test
    public void payTicket() {
        ticket.setExitTimestamp(LocalDateTime.now());
        ticket.setCost(new BigDecimal("10"));
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);
        Ticket payedTicket = ticketRepository.save(ticket);
        assertThat(payedTicket.getCost()).isEqualTo(new BigDecimal(10));
        assertThat(payedTicket.getExitTimestamp()).isNotNull();
    }
}
