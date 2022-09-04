package com.cedrus.StatisticsService.service;

import com.cedrus.StatisticsService.model.Floor;
import com.cedrus.StatisticsService.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cedrus.StatisticsService.utils.StatisticsServiceUtils.toList;

@Service
public class FloorService {

    @Autowired
    FloorRepository floorRepository;

    public List<Floor> getAllFloors(){
        return toList(floorRepository.findAll());
    }
}
