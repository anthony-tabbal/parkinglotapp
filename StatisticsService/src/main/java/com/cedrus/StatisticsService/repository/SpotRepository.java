package com.cedrus.StatisticsService.repository;

import com.cedrus.StatisticsService.model.Spot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotRepository extends CrudRepository<Spot,String> {

    Iterable<Spot> findByIsAvailableAndSpotTypeAndFloorFloorId(boolean isAvailable, String spotType, String floorId);
}
