package com.teachmeskills.calc.dao;

import com.teachmeskills.calc.model.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryOperationDao implements OperationDao {
    private static List<Operation> operations = new ArrayList<>();
    private static OperationDao instance;

    private InMemoryOperationDao() {
    }

    public static OperationDao getInstance(){
        if (instance == null){
            instance = new InMemoryOperationDao();
        }
        return instance;
    }

    public void add(Operation operation){
        operations.add(operation);
    }

    public List<Operation> getOperations() {
        return new ArrayList<>(operations);
    }

    @Override
    public void removeAll() {
        operations.removeAll(operations);
    }
}
