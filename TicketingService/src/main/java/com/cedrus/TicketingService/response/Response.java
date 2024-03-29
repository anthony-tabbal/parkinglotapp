package com.cedrus.TicketingService.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String status;
    private String message;
    private T data;

}