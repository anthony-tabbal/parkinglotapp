package com.cedrus.TicketingService.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vehicleType;
}
