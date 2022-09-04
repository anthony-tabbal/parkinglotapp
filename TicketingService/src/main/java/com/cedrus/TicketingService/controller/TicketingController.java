package com.cedrus.TicketingService.controller;

import com.cedrus.TicketingService.request.CreateTicketRequest;
import com.cedrus.TicketingService.response.CreatedTicketResponse;
import com.cedrus.TicketingService.response.PayedTicketResponse;
import com.cedrus.TicketingService.response.Response;
import com.cedrus.TicketingService.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/ticketing")
public class TicketingController {

    @Autowired
    TicketService ticketService;

    @PostMapping(value = "/create-ticket")
    public Response<CreatedTicketResponse> createTicket(@RequestBody CreateTicketRequest createTicketRequest){
        return new Response<CreatedTicketResponse>("200", "success",ticketService.createTicket(createTicketRequest));
    }

    @PutMapping(value = "/pay-ticket/{ticketId}")
    public Response<PayedTicketResponse> payTicket(@PathVariable String ticketId){
        return new Response<PayedTicketResponse>("200", "success", ticketService.payTicket(ticketId));
    }
}
