package com.lewandowska.julia.service;

import com.lewandowska.julia.entity.TransactionEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

@Component
public class ReadFileCsv {

    public List<TransactionEntity> readData(String path) throws FileNotFoundException {

        File file = new File(path);
        Scanner in = new Scanner(file);
        List<TransactionEntity> responseList = new LinkedList<>();

        try {
            Stream<String> lines = Files.lines(Paths.get(path));
            lines.
                    map(k -> k.split(",")). //
                    forEach(tab -> responseList.add(new TransactionEntity(Long.parseLong(tab[0]), //
                    tab[1].substring(1, tab[1].length() - 1), Integer.parseInt(tab[2]), Integer.parseInt(tab[3]), //
                    tab[4].substring(1, tab[4].length() - 1), Boolean.parseBoolean(tab[5])))); //
            lines.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseList;
    }
}