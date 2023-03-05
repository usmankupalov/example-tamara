package com.example.shopinternet.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Violation {
    private final String fieldMessage;
    private final String message;
}
