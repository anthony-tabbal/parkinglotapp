package com.cedrus.TicketingService.utils;

import com.cedrus.TicketingService.response.Response;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public static <T extends Object> T  jsonToObject(String jsonPayload, Class<T> clazz){
        Gson gson = new Gson();
        return gson.fromJson(jsonPayload, clazz);
    }
}
