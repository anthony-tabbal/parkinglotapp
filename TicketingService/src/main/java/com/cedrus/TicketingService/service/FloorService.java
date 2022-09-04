package com.cedrus.TicketingService.service;

import com.cedrus.TicketingService.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorService {

    @Autowired
    FloorRepository floorRepository;
}
