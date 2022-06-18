package com.local.conferencebooking.controllers;

import org.springframework.validation.BindingResult;

import java.util.*;

public class ControllerUtils {

    static Map<String, String> getErrors(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().stream().forEach(
                x-> errors.putIfAbsent(x.getField()+"Error", x.getDefaultMessage())
        );
        return errors;
    }
}
