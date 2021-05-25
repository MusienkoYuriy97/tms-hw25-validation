package com.teachmeskills.calc.model.calc;

import com.teachmeskills.calc.dao.OperationDao;
import com.teachmeskills.calc.model.Operation;
import com.teachmeskills.calc.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class Subtract implements Action {
    @Autowired
    private OperationDao operationDao;

    @Override
    public double calculate(double x, double y, User sessionUser) {
        double result = x - y;
        operationDao.add(new Operation(x,y,result,"Вычитание",sessionUser));
        return result;
    }
}