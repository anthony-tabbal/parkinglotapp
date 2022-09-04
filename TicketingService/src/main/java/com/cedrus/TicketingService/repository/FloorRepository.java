package com.cedrus.TicketingService.repository;

import com.cedrus.TicketingService.model.Floor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends CrudRepository<Floor,String> {

}
