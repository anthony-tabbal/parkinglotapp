package com.cedrus.StatisticsService.service;

import com.cedrus.StatisticsService.enums.VehicleTypeEnums;
import com.cedrus.StatisticsService.model.Spot;
import com.cedrus.StatisticsService.repository.SpotRepository;
import com.cedrus.StatisticsService.response.AvailableSpotsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpotService {

    @Autowired
    SpotRepository spotRepository;

    public AvailableSpotsResponse getAvailableSpotsByFloor(String floorId) {
        Map<String, List<String>> availableSpots = new HashMap<>();

        for (VehicleTypeEnums type : VehicleTypeEnums.values()) {
            List<String> spotIds = new ArrayList<>();
            Iterable<Spot> availableSpotsList = spotRepository.findByIsAvailableAndSpotTypeAndFloorFloorId(true, type.getType(), floorId);
            for (Spot spot : availableSpotsList) {
                spotIds.add(spot.getSpotId());
            }
            availableSpots.put(type.getType(), spotIds);
        }

        return new AvailableSpotsResponse(availableSpots);
    }


}
