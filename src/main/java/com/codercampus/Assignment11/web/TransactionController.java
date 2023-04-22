package com.codercampus.Assignment11.web;


import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    TransactionService tranService;


    @GetMapping("/transactions")
    public String getTransactions(ModelMap model) {
        List<Transaction> transactions = tranService.findAll();
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
               return o1.getDate().compareTo(o2.getDate());
            }
        });

        model.put("transactions", transactions);
        return "transactions";
    }

    @GetMapping("/transactions/{transactionId}")
    public String getTransactionsId(@PathVariable Long transactionId, ModelMap model) {
        model.put("transaction",tranService.findById(transactionId));
        return "transaction";
    }
}
