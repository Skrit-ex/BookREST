package com.example.bookstorerest.repository;

import com.example.bookstorerest.entity.Operation;
import org.springframework.stereotype.Repository;


@Repository
public interface CalculatorOperation {

    void process();

    Operation getFinalResult();
}
