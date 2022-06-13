package com.local.conferencebooking.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtils {

    static Map<String, String> getErrors(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().stream().forEach(
                x-> errors.putIfAbsent(x.getField()+"Error", x.getDefaultMessage())
        );
        return errors;
    }
}
