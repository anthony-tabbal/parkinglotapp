package com.cedrus.TicketingService.model;

import com.cedrus.TicketingService.model.Spot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

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
