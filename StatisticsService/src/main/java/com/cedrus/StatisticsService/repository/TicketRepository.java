package com.cedrus.StatisticsService.repository;

import com.cedrus.StatisticsService.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, String> {

    @Query(nativeQuery = true, value = "Select t.ticket_id, t.spot_id, t.entrance_timestamp, t.exit_timestamp, t.cost " +
            "from ticket t left join spot s on s.spot_id = t.spot_id " +
            "Where s.floor_id = :floorId " +
            "and t.cost is not null " +
            "and (cast(:onDate as date) is null or date(t.exit_timestamp) = :onDate)")
    public Iterable<Ticket> findAllByCostNotNullAndSpotFloorFloorId(@Param("floorId") String floorId, @Param("onDate") LocalDate onDate);
}
