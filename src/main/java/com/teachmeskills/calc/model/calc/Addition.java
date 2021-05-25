package com.teachmeskills.calc.model.calc;

import com.teachmeskills.calc.dao.OperationDao;
import com.teachmeskills.calc.model.Operation;
import com.teachmeskills.calc.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class Addition implements Action {
    @Autowired
    private OperationDao operationDao;

    @Override
    public double calculate(double x, double y, User sessionUser) {
        double result = x + y;
        operationDao.add(new Operation(x,y,result,"Сложение",sessionUser));
        return result;
    }
}
