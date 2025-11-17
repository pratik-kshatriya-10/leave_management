package com.pheonix.leavemanagement.controllers;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class BaseRestController {

    private static final String MESSAGE = "message";
    private static final String STATUS = "status";

    protected ResponseEntity<Map<String, String>> constructSuccessResponse(String message, String status) {
        Map<String, String> response = new HashMap<>();
        response.put(MESSAGE, message);
        response.put(STATUS, status);

        return ResponseEntity.ok(response);
    }
}
