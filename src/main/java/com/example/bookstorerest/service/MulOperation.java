package com.example.bookstorerest.service;

import com.example.bookstorerest.entity.Operation;
import com.example.bookstorerest.repository.CalculatorOperation;

public class MulOperation implements CalculatorOperation {

    private final Operation operation;

    public MulOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void process() {
        operation.setResult(operation.getNum1()* operation.getNum2());
    }

    @Override
    public Operation getFinalResult() {
        return operation;
    }
}
