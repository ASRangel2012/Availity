package CSVParser;
import Model.User;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.nio.file.spi.FileTypeDetector;

import static java.nio.file.Files.probeContentType;

public class EnrolleeCSVParser {
    public Scanner scan = new Scanner(System.in);

    /**
     * Method to read CSV file and convert to Bean for faster reading
     *
     * @return fully parsed list from csv
     * @throws FileNotFoundException
     */
    public List<User> readCSVFile() throws FileNotFoundException {
        FileReader reader = new FileReader("C:\\Users\\ASRAn\\IdeaProjects\\Availity\\src\\main\\java\\Driver\\Enrollees_20220428.csv");
        CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader)
                .withType(User.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean.parse();
    }
}
