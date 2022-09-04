package com.cedrus.TicketingService.utils;

import com.google.gson.Gson;

public class JsonUtils {

    public static <T extends Object> T jsonToObject(String jsonPayload, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonPayload, clazz);
    }
}
