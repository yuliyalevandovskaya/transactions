package com.lewandowska.julia.service;

import com.lewandowska.julia.entity.SummaryTransactionsEntity;
import com.lewandowska.julia.entity.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class TransactionService {

    private final ReadFileCsv readFileCsv;
    private final StatisticsTransactions statisticsTransactions;

    @Autowired
    public TransactionService(ReadFileCsv readFileCsv, StatisticsTransactions statisticsTransactions) {
        this.readFileCsv = readFileCsv;
        this.statisticsTransactions = statisticsTransactions;
    }

    public Optional<List<TransactionEntity>> findAll() throws FileNotFoundException {
        return Optional.of(readFileCsv.readData("data.csv"));
    }

    public Optional<List<SummaryTransactionsEntity>> statisticsTrans() throws FileNotFoundException {
        return Optional.of(statisticsTransactions.statisticsTransactions("data.csv"));
    }

    public Optional<SummaryTransactionsEntity> findTransaction(String type, String currency) throws FileNotFoundException {
        return statisticsTrans() //
                .get() //
                .stream() //
                .filter(tr -> { //
                    return tr.getCurrency().equals(currency) && tr.getType().equals(type);
                })
                .findFirst(); //
    }
}