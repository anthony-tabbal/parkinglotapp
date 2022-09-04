package com.cedrus.StatisticsService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "floor")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Floor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "floor_id")
    private String floorId;

    @Column(name = "floor_number")
    private int floorNumber;

    @Column(name ="maximum_spots")
    private int maximumSpots;
}
