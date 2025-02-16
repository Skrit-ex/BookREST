package com.example.bookstorerest.factory;

import com.example.bookstorerest.entity.Operation;
import com.example.bookstorerest.repository.CalculatorOperation;
import com.example.bookstorerest.service.DifOperation;
import com.example.bookstorerest.service.DivOperation;
import com.example.bookstorerest.service.MulOperation;
import com.example.bookstorerest.service.SumOperation;

import java.util.Optional;

public abstract class OperationFactory {


    public static Optional<CalculatorOperation> createOperation(Operation operation) {
        switch (operation.getType()) {
            case SUM:
                return Optional.of(new SumOperation(operation));
            case DIV:
                return Optional.of(new DivOperation(operation));
            case MUL:
                return Optional.of(new MulOperation(operation));
            case DIF:
                return Optional.of(new DifOperation(operation));
            }
            return Optional.empty();
        }
    }