package com.cedrus.StatisticsService.controller;

import com.cedrus.StatisticsService.response.AvailableSpotsResponse;
import com.cedrus.StatisticsService.response.Response;
import com.cedrus.StatisticsService.response.TicketPriceResponse;
import com.cedrus.StatisticsService.response.TicketSoldAndIncomeResponse;
import com.cedrus.StatisticsService.service.SpotService;
import com.cedrus.StatisticsService.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.cedrus.StatisticsService.constant.StatisticsServiceConstants.DATE_FORMAT;
import static com.cedrus.StatisticsService.constant.StatisticsServiceConstants.ON_DATE;

@RestController
@RequestMapping(value = "/api/statistics")
public class SatisticsController {

    @Autowired
    TicketService ticketService;

    @Autowired
    SpotService spotService;

    @GetMapping(value = "/ticket-price/{ticketId}")
    public Response<TicketPriceResponse> getTicketPrice(@PathVariable String ticketId) {
        return new Response<TicketPriceResponse>("200", "success", ticketService.getTicketPrice(ticketId));
    }

    @GetMapping(value = "/floor/available-spots-number")
    public Response<AvailableSpotsResponse> getAvailableSpotsByFloor(@RequestParam String floorId) {
        return new Response<AvailableSpotsResponse>("200", "success", spotService.getAvailableSpotsByFloor(floorId));
    }

    @GetMapping(value = "/ticket-sold/income")
    public Response<TicketSoldAndIncomeResponse> getTicketSoldPerFloorAndTotalIncome(@RequestParam(value = ON_DATE, required = false)
                                                                                     @DateTimeFormat(pattern = DATE_FORMAT) LocalDate onDate) {
        return new Response<TicketSoldAndIncomeResponse>("200", "success", ticketService.getTicketSoldPerFloorAndTotalIncome(onDate));
    }
}
