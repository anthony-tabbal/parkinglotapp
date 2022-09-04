package com.cedrus.TicketingService.utils;

import com.netflix.discovery.EurekaClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TicketingServiceUtils {


    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public static String generateUUiD() {
        return UUID.randomUUID().toString();
    }

    public static String getApi(RestTemplate restTemplate, String serviceName, EurekaClient discoveryClient, String pathVariable, String getUrl) {
        String url = discoveryClient.getNextServerFromEureka(serviceName, false).getHomePageUrl();
        return restTemplate.getForEntity(url + getUrl + "/" + pathVariable, String.class).getBody();
    }
}
