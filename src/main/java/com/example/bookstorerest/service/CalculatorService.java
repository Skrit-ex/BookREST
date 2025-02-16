package com.example.bookstorerest.service;

import com.example.bookstorerest.entity.Operation;
import com.example.bookstorerest.entity.User;
import com.example.bookstorerest.factory.OperationFactory;
import com.example.bookstorerest.repository.CalculatorOperation;
import com.example.bookstorerest.repository.OperationRepository;
import com.example.bookstorerest.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CalculatorService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OperationRepository operationRepository;

    public Optional<CalculatorOperation> calculate(Operation operation){

        User user = userRepository.findById(operation.getId()).orElse(null);
        if(user != null) {
            operation.setUser(user);
        }else {
            log.error("User not found " + user);
        }
        Optional<CalculatorOperation> optionalCalculatorOperation = OperationFactory.createOperation(operation);
        if(optionalCalculatorOperation.isPresent()){
            CalculatorOperation calculatorOperation = optionalCalculatorOperation.get();
            calculatorOperation.process();
            if(operation.getUser() != null){
                operationRepository.save(calculatorOperation.getFinalResult());
            }
            return Optional.of(calculatorOperation);
            }
        return Optional.empty();
        }

}
