package com.cedrus.TicketingService.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookedSpotResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String spotId;

    private int floorNumber;
}
