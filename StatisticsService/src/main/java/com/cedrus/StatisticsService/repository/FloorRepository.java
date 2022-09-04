package com.cedrus.StatisticsService.repository;

import com.cedrus.StatisticsService.model.Floor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends CrudRepository<Floor,String> {
}
