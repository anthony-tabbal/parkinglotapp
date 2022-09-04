package com.cedrus.StatisticsService.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TicketPriceResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal ticketCost;
}
