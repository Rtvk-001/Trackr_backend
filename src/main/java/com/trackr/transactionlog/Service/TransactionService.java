package com.trackr.transactionlog.Service;

import com.trackr.transactionlog.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TransactionService
{
    public Transaction saveTransaction(Transaction transaction);
    public List<Transaction> getAllTransactions();
    public Transaction findTransaction(@PathVariable int id);


    public void updateTransaction(int id,Transaction transaction);
    public void deleteTransaction (Transaction transaction);
}
