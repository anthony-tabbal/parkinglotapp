package com.cedrus.StatisticsService.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TicketSoldAndIncomeResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<Integer, List<String>> ticketsSoldByFloor;

    private BigDecimal totalIncome;
}
