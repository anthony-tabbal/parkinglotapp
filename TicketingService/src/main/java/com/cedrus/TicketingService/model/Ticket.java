package com.cedrus.TicketingService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ticket_id")
    private String ticketId;

    @ManyToOne
    @JoinColumn(name = "spot_id")
    private Spot spot;

    @Column(name = "entrance_timestamp")
    private LocalDateTime entranceTimestamp;

    @Column(name = "exit_timestamp")
    private LocalDateTime exitTimestamp;

    @Column(name = "cost")
    private BigDecimal cost;

}
