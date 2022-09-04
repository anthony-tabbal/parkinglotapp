package com.cedrus.StatisticsService.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableSpotsResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, List<String>> availableSpots;
}
