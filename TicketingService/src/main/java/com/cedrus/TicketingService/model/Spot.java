package com.cedrus.TicketingService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "spot")
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
