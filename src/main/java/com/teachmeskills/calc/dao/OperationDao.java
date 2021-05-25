package com.teachmeskills.calc.dao;

import com.teachmeskills.calc.model.Operation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OperationDao {
    void add(Operation operation);
    List<Operation> getOperations();
    void removeAll();
}
