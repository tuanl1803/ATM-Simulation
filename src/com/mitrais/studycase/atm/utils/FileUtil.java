package com.mitrais.studycase.atm.utils;

import com.mitrais.studycase.atm.models.Account;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void readFileCSV() throws IOException {
        String pathToCsv = "";
        File csvFile = new File(pathToCsv);
        if (csvFile.isFile()) {
            // create BufferedReader and read data from csv
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
            String row = csvReader.readLine();
            List<String> data = new ArrayList<>();
            List<Account> accountList = new ArrayList<>();
            while (row != null) {
                data.add(row);
                String[] record = row.split("\\,");
                accountList.add(new Account(record[0], record[1], record[2], Integer.parseInt(record[3])));

            }
            csvReader.close();
        }
    }

    public static void writeFileCSV() {

    }


}
