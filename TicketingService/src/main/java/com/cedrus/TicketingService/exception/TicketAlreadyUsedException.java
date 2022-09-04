package com.cedrus.TicketingService.exception;

public class TicketAlreadyUsedException extends RuntimeException {

    public TicketAlreadyUsedException() {

        super("Ticket already used");
    }
}
