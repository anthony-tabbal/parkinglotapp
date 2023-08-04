package com.cedrus.StatisticsService.service;

import com.cedrus.StatisticsService.exception.NoDataFoundException;
import com.cedrus.StatisticsService.model.Floor;
import com.cedrus.StatisticsService.model.Ticket;
import com.cedrus.StatisticsService.repository.TicketRepository;
import com.cedrus.StatisticsService.response.TicketPriceResponse;
import com.cedrus.StatisticsService.response.TicketSoldAndIncomeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FloorService floorService;

    public TicketPriceResponse getTicketPrice(String ticketId){
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);

        if(ticket.isEmpty()){
            throw new NoDataFoundException();
        }

        BigDecimal cost = calculateTicketPrice(ticket.get().getEntranceTimestamp(), ticket.get().getExitTimestamp() != null ?
                ticket.get().getExitTimestamp() : LocalDateTime.now());

        return new TicketPriceResponse(cost);
    }

    public BigDecimal calculateTicketPrice(LocalDateTime startTime, LocalDateTime endTime){
        long initHour = 1;
        long totalHours = ChronoUnit.HOURS.between(startTime, endTime);
        BigDecimal price = new BigDecimal(BigInteger.ZERO);

        while(initHour <= totalHours){
            if(initHour <= 1){
                price = price.add(new BigDecimal(4));
            }else if (initHour <= 3){
                price = price.add(new BigDecimal("3.5"));
            }else {
                price = price.add(new BigDecimal("2.5"));
            }
            initHour++;
        }

        return price;
    }

    public TicketSoldAndIncomeResponse getTicketSoldPerFloorAndTotalIncome(LocalDate onDate){
        List<Floor> allFloors = floorService.getAllFloors();
        Map<Integer, List<String>> soldTicketsPerFloor = new HashMap<>();
        BigDecimal totalCost = new BigDecimal(0);

        for(Floor floor : allFloors) {
            Iterable<Ticket> allSoldTickets = ticketRepository.findAllByCostNotNullAndSpotFloorFloorId(floor.getFloorId(), onDate);
            List<String> ticketIds = new ArrayList<>();
            for(Ticket ticket : allSoldTickets){
                ticketIds.add(ticket.getTicketId());
                totalCost = totalCost.add(ticket.getCost());
            }
            soldTicketsPerFloor.put(floor.getFloorNumber(), ticketIds);
        }

        return new TicketSoldAndIncomeResponse(soldTicketsPerFloor, totalCost);
    }
}
