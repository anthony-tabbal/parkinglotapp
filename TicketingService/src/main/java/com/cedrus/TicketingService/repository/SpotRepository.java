package com.cedrus.TicketingService.repository;

import com.cedrus.TicketingService.model.Spot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpotRepository extends CrudRepository<Spot, String> {

    public Optional<Spot> findFirstBySpotTypeAndIsAvailable(String spotType, boolean isAvailable);
}
