package com.codercampus.Assignment11.services;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class TransactionService {

    @Autowired
    TransactionRepository transRepo;


    public List<Transaction> findAll() {
        return transRepo.findAll();
    }

    public Transaction findById(Long id) {
        return transRepo.findById(id);
    }
}
