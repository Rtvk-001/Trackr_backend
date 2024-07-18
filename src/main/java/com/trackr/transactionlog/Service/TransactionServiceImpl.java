package com.trackr.transactionlog.Service;

import com.trackr.transactionlog.model.Transaction;
import com.trackr.transactionlog.repo.TransRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService
{
    @Autowired
    private TransRepo transRepo;
    @Override
    public Transaction saveTransaction(Transaction transaction)
    {
        return transRepo.save(transaction);
    }
    @Override
    public List<Transaction> getAllTransactions()
    {
        return transRepo.findAll();
    }
    @Override
    public Transaction findTransaction(@PathVariable int id)
    {
        Transaction transaction = transRepo.findById(id).get();
        return transaction;
    }
    //RECHECK FOR UPDATE AND DELETE
    @Override
    public void updateTransaction(int id,Transaction transaction)
    {
        transRepo
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"INVALID USER ID" +id));
        transaction.setId(id);
        transRepo.save(transaction);
    }
    @Override
    public void deleteTransaction(Transaction transaction)
    {
        transRepo.delete(transaction);
    }

}
