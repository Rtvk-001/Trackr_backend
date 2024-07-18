package com.trackr.transactionlog.controller;

import com.trackr.transactionlog.Service.TransactionService;
import com.trackr.transactionlog.model.Transaction;
import com.trackr.transactionlog.repo.TransRepo;
import com.trackr.transactionlog.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/")//set Mapping after structure definition
@CrossOrigin
public class TransactionController
{

    @Autowired //WTF is this
    private TransRepo transRepo;
    @Autowired
    private TransactionService transactionService;
    @PostMapping("/addTransaction")
    public String add(@RequestBody Transaction transaction)
    {
        transactionService.saveTransaction(transaction);
        return "Transaction added";
    }

    @GetMapping("/allTransactions")
    public List<Transaction> list()
    {
        return transactionService.getAllTransactions();
    }
    @GetMapping("/allTransactions/{id}")
    public Transaction findTransaction(@PathVariable int id)
    {
        return transactionService.findTransaction(id);
    }

   @PutMapping("/transaction/{id}")
    public String updateTransaction(@PathVariable int id, @RequestBody Transaction transaction)
   {
       transactionService.updateTransaction(id,transaction);
       return "Transaction Updated";
    }
    @DeleteMapping("/transaction/{id}")
    public String deleteTransaction(@PathVariable int id, Transaction transaction) {
        transactionService.deleteTransaction(transaction);
        return "Transaction Deleted";
    }


}
