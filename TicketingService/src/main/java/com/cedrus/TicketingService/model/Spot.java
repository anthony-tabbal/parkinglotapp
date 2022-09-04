package com.cedrus.TicketingService.model;

import com.cedrus.TicketingService.model.Floor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="spot")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Spot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "spot_id")
    private String spotId;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @Column(name = "spot_type")
    private String spotType;

    @Column(name = "availability")
    private boolean isAvailable;

}
