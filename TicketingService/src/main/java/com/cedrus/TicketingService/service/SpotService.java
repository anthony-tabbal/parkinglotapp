package com.cedrus.TicketingService.service;

import com.cedrus.TicketingService.exception.NoDataFoundException;
import com.cedrus.TicketingService.model.Spot;
import com.cedrus.TicketingService.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpotService {

    @Autowired
    SpotRepository spotRepository;

    public Spot bookSpot(String vehicleType) {
        Optional<Spot> spot = spotRepository.findFirstBySpotTypeAndIsAvailable(vehicleType, true);
        if (spot.isEmpty()) {
            throw new NoDataFoundException();
        }
        Spot availableSpot = spot.get();
        availableSpot.setAvailable(false);
        return spotRepository.save(availableSpot);
    }
}
