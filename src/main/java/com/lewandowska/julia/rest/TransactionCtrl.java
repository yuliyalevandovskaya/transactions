package com.lewandowska.julia.rest;

import com.lewandowska.julia.dto.TransactionParam;
import com.lewandowska.julia.entity.SummaryTransactionsEntity;
import com.lewandowska.julia.entity.TransactionEntity;
import com.lewandowska.julia.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionCtrl {

    private final TransactionService transactionService;

    @Autowired
    public TransactionCtrl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public SummaryTransactionsEntity findTransaction(@RequestBody TransactionParam transactionParam) throws FileNotFoundException {

      return transactionService.findTransaction(transactionParam.getType(), transactionParam.getCurrency()).get();
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public List<SummaryTransactionsEntity> statisticsTransactions() throws FileNotFoundException {

        return transactionService.statisticsTrans().get();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TransactionEntity> allTransactions() throws FileNotFoundException {

        return transactionService.findAll().get();
    }
}