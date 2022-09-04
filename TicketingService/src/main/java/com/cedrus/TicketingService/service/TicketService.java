package com.cedrus.TicketingService.service;

import com.cedrus.TicketingService.exception.NoDataFoundException;
import com.cedrus.TicketingService.exception.TicketAlreadyUsedException;
import com.cedrus.TicketingService.model.Spot;
import com.cedrus.TicketingService.model.Ticket;
import com.cedrus.TicketingService.repository.SpotRepository;
import com.cedrus.TicketingService.repository.TicketRepository;
import com.cedrus.TicketingService.request.CreateTicketRequest;
import com.cedrus.TicketingService.response.*;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.cedrus.TicketingService.utils.JsonUtils.jsonToObject;
import static com.cedrus.TicketingService.utils.TicketingServiceUtils.*;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    SpotService spotService;


    @Autowired
    private EurekaClient discoveryClient;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${statistics.service.name}")
    private String statisticsServiceName;

    @Value("${statistics.service.get.price.url}")
    private String statisticsServiceGetPriceUrl;


    public CreatedTicketResponse createTicket(CreateTicketRequest createTicketRequest){
        Spot availableSpot = spotService.bookSpot(createTicketRequest.getVehicleType());
        Ticket ticket = new Ticket(generateUUiD(), availableSpot, LocalDateTime.now(), null, null);
        Ticket createdTicket = ticketRepository.save(ticket);

        return new CreatedTicketResponse(createdTicket.getTicketId(), new BookedSpotResponse(availableSpot.getSpotId(),
                availableSpot.getFloor().getFloorNumber()), createdTicket.getEntranceTimestamp());
    }

    public PayedTicketResponse payTicket(String ticketId){
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if(ticket.isEmpty()){
            throw new NoDataFoundException();
        }
        Ticket ticketToUpdate = ticket.get();
        if(ticketToUpdate.getExitTimestamp() != null || ticketToUpdate.getCost() != null){
            throw new TicketAlreadyUsedException();
        }
        String responseEntity = getApi(restTemplate(),statisticsServiceName,discoveryClient,ticketId,statisticsServiceGetPriceUrl);
        Response response = jsonToObject(responseEntity, Response.class);
        TicketPriceResponse ticketPriceResponse = jsonToObject(response.getData().toString(), TicketPriceResponse.class);

        ticketToUpdate.setExitTimestamp(LocalDateTime.now());
        ticketToUpdate.setCost(ticketPriceResponse.getTicketCost());
        ticketToUpdate.getSpot().setAvailable(true);
        Ticket savedTicket = ticketRepository.save(ticketToUpdate);

        return new PayedTicketResponse(savedTicket.getTicketId(), savedTicket.getEntranceTimestamp(), savedTicket.getExitTimestamp(), savedTicket.getCost());
    }
}
