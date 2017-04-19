package com.lewandowska.julia;

import com.lewandowska.julia.entity.SummaryTransactionsEntity;
import com.lewandowska.julia.entity.TransactionEntity;
import com.lewandowska.julia.service.ReadFileCsv;
import com.lewandowska.julia.service.StatisticsTransactions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;

public class TransactionsApplicationTests {

    List<TransactionEntity> transactionEntityList = Arrays.asList(new TransactionEntity(1L, "trip", 20, 5, "EUR", true),
            new TransactionEntity(2L, "ticket", 10, 2, "EUR", true),
            new TransactionEntity(3L, "trip", 50, 18, "EUR", true));

    ReadFileCsv readFileCsv = new ReadFileCsv();
    StatisticsTransactions statisticsTransactions = new StatisticsTransactions(readFileCsv);

    @Test
    public void readFileTest() throws FileNotFoundException {
        Assert.assertEquals(transactionEntityList, readFileCsv.readData("data_test.csv"));
    }

    @Test
    public void statisticsSummaryTest() throws FileNotFoundException {
        Assert.assertTrue(!statisticsTransactions.statisticsTransactions("data_test.csv").isEmpty());
        Assert.assertTrue(statisticsTransactions.statisticsTransactions("data_test.csv").size() == 2);
    }
}