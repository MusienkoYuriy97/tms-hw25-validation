package com.teachmeskills.calc.model.calc;

import com.teachmeskills.calc.model.User;

public interface Action {
    double calculate(double x, double y, User sessionUser);
}