package com.teachmeskills.calc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    private double x;
    private double y;
    private double result;
    private String operationType;
    private User user;
}
