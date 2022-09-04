package com.cedrus.StatisticsService;

import com.cedrus.StatisticsService.model.Floor;
import com.cedrus.StatisticsService.model.Spot;
import com.cedrus.StatisticsService.model.Ticket;
import com.cedrus.StatisticsService.repository.TicketRepository;
import com.cedrus.StatisticsService.response.TicketPriceResponse;
import com.cedrus.StatisticsService.response.TicketSoldAndIncomeResponse;
import com.cedrus.StatisticsService.service.FloorService;
import com.cedrus.StatisticsService.service.SpotService;
import com.cedrus.StatisticsService.service.TicketService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
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
    private TicketRepository ticketRepository;

    @Mock
    private FloorService floorService;


    @BeforeAll
    public void setupTicket() {
        floor = new Floor(UUID.randomUUID().toString(), 1, 40);
        spot = new Spot(UUID.randomUUID().toString(), floor, "Compact", true);
        ticket = new Ticket(UUID.randomUUID().toString(), spot, LocalDateTime.now(), LocalDateTime.now().plusHours(4), null);
    }

    @Test
    public void getTicketPrice() {
        when(ticketRepository.findById(anyString())).thenReturn(Optional.of(ticket));
        TicketPriceResponse ticketPriceResponse = ticketService.getTicketPrice(ticket.getTicketId());
        assertThat(ticketPriceResponse.getTicketCost()).isEqualTo(new BigDecimal(13.5));
    }

    @Test
    public void getTicketSoldPerFloorAndTotalIncome() {
        ticket.setCost(new BigDecimal(12));
        List<Floor> floors = new ArrayList<>();
        floors.add(floor);
        floors.add(new Floor(UUID.randomUUID().toString(), 2, 45));
        floors.add(new Floor(UUID.randomUUID().toString(), 3, 43));
        when(floorService.getAllFloors()).thenReturn(List.of(floor));
        when(ticketRepository.findAllByCostNotNullAndSpotFloorFloorId(anyString(), any(LocalDate.class))).thenReturn(List.of(ticket));

        TicketSoldAndIncomeResponse ticketSoldAndIncomeResponse = ticketService.getTicketSoldPerFloorAndTotalIncome(LocalDate.now());

        assertThat(ticketSoldAndIncomeResponse.getTotalIncome()).isEqualTo(new BigDecimal(12));
        assertThat(ticketSoldAndIncomeResponse.getTicketsSoldByFloor().get(1).get(0)).isEqualTo(ticket.getTicketId());
    }
}
