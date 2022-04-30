package CSVParser;
import Model.User;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class EnrolleeCSVParser {

    /**
     * Method to read CSV file and convert to Bean for faster reading
     * @return fully parsed list from csv
     * @throws FileNotFoundException
     */
    public List<User> readCSVFile() throws FileNotFoundException {

        FileReader reader = new FileReader("C:\\Users\\aylar\\OneDrive\\Documents\\GitHub\\Sandbox\\src\\main\\java\\Driver\\Enrollees_20220428.csv");
        CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader)
                .withType(User.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean.parse();
    }
}
