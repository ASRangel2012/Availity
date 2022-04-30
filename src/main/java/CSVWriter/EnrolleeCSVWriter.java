package CSVWriter;

import Model.User;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class EnrolleeCSVWriter {

    public void createCSV(String fileName) throws IOException {
        Writer writer = new FileWriter(fileName);
        StatefulBeanToCsv<User> beanToCsv = new StatefulBeanToCsvBuilder<User>(writer)
                .withLineEnd(com.opencsv.CSVWriter.DEFAULT_LINE_END)
                .withOrderedResults(true)
                .build();
    }

}