package com.lewandowska.julia.service;

import com.lewandowska.julia.entity.SummaryTransactionsEntity;
import com.lewandowska.julia.entity.TransactionEntity;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class StatisticsTransactions {

    private final ReadFileCsv readFileCsv;

    public StatisticsTransactions(ReadFileCsv readFileCsv) {
        this.readFileCsv = readFileCsv;
    }

    public List<SummaryTransactionsEntity> statisticsTransactions(String path) throws FileNotFoundException {
        List<TransactionEntity> listData = readFileCsv.readData(path);
        List<SummaryTransactionsEntity> listResponse = new LinkedList<>();
        Boolean isPaid = false;
        String currency = "";
        String type = "";
        Integer price = 0;
        Integer commission = 0;
        Integer toChargeValue = 0;
        Integer settlementValue = 0;

        Map<String, Map<String, List<TransactionEntity>>> map2 = listData.stream()
                .collect(Collectors.groupingBy(TransactionEntity::getType,
                        Collectors.groupingBy(TransactionEntity::getCurrency)));

        for (Map.Entry<String, Map<String, List<TransactionEntity>>> e : map2.entrySet()) {
            for (Map.Entry<String, List<TransactionEntity>> en : e.getValue().entrySet()) {
                for (TransactionEntity t : en.getValue()) {

                    isPaid = t.getPaid();
                    currency = t.getCurrency();
                    type = t.getType();
                    price += t.getPrice();
                    commission += t.getCommission();
                }

                if (!isPaid) {
                    toChargeValue += price;
                }
                settlementValue = price - commission - toChargeValue;

                listResponse.add(new SummaryTransactionsEntity(1L, type, price, commission, currency,
                        false, toChargeValue, settlementValue));
                price = 0;
                commission = 0;
                toChargeValue = 0;
            }
        }
        return listResponse;
    }
}