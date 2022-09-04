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
@AllArgsConstructor
@NoArgsConstructor
public class PayedTicketResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ticketNumber;

    private LocalDateTime entranceTimestamp;

    private LocalDateTime exitTimestamp;

    private BigDecimal cost;
}
