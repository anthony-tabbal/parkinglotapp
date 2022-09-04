package com.cedrus.TicketingService.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatedTicketResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ticketId;

    private BookedSpotResponse bookedSpot;

    private LocalDateTime entranceTimestamp;
}
