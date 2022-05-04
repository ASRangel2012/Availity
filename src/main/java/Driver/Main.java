package Driver;

import CSVHelperMethods.HelperMethod;
import CSVParser.EnrolleeCSVParser;
import LISP_Validator.LispValidatorUsingDeque;
import Model.User;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Main {
    public static List<String> companyList = new ArrayList<String>();
    public static Map<String, User> userHashMap = new HashMap<>();

    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        String testLispCodeMethod = "(* 2 (cos 0) (+ 4 6))";
        String testLispCodeMethod2 = "5(+ 1 2)";
        String testLispCodeMethod3 = "(pprint (string-upcase foo))";
        String testLispCodeMethod4 = "(if x (format t \"yes\") (format t \"no\")))";
        String testLispCodeMethod5 = "(* (+ 1 2) (- 3 4))";
        String nestedLISP = "(defun print-list (list)" +
                "  (dolist (i list)" +
                "    (format t \"item: ~a~%\" i)))";
        String nestedLisp2 = """
                (defun read-lines (file)
                  "Return a list of lines in FILE."
                  (with-temp-buffer
                    (insert-file-contents file)
                    (split-string
                     (buffer-string) "" t)))

                (mapcar
                 (lambda (x)
                   (mapcar
                    (lambda (y) (string-to-number y))
                    (split-string x " ")))
                 (read-lines "blob.txt"))\s""";

        LispValidatorUsingDeque LISP = new LispValidatorUsingDeque();
        System.out.println(LISP.isLISPCodeValid(testLispCodeMethod));
        System.out.println(LISP.isLISPCodeValid(testLispCodeMethod2));
        System.out.println(LISP.isLISPCodeValid(testLispCodeMethod3));
        System.out.println(LISP.isLISPCodeValid(testLispCodeMethod4));
        System.out.println(LISP.isLISPCodeValid(testLispCodeMethod5));
        System.out.println(LISP.isLISPCodeValid(nestedLISP));
        System.out.println(LISP.isLISPCodeValid(nestedLisp2));
        System.out.println(LISP.isLISPCodeValid(null)); //checking for null string
        System.out.println(LISP.isLISPCodeValid("")); //checking for empty string

        //------------------------Testing CSV Parsing & Writing----------------------
        EnrolleeCSVParser CSVParser = new EnrolleeCSVParser();
        HelperMethod helper = new HelperMethod();

        List<User> userList = CSVParser.readCSVFile(); // reads whole file
        List<User> filteredUsers = helper.filterList(userList); //filters the null, empty fields
        userList.addAll(userHashMap.values());
        companyList = helper.filterByInsuranceCompany(userList, companyList);

        for (User user : filteredUsers) {
            helper.mapCompanyToUser(user, userHashMap);
        }

        List<User> finalList = new ArrayList<User>(userHashMap.values());
        helper.sortByLastName(finalList);
        System.out.println(finalList);

        for(String company: companyList) {
            FileWriter writer = new FileWriter(company + ".csv");
            writer.write("User ID, Last Name,First Name,Version,Insurance Company\n");
            for (User user : finalList) {
                try {
                    if (user.getInsuranceCompany().equals(company)) {
                        writer.write(user.toString());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            writer.close();
        }
    }
}

//        for(String company: companyList){
//            FileWriter writer = new FileWriter(company + ".csv");
//            for (Map.Entry<String, User> entry : userHashMap.entrySet()) {
//                String s = entry.getKey();
//                User user = entry.getValue();
//                try {
//
//                    if(user.getInsuranceCompany().equals(company)){
//                        writer.write(String.valueOf(user));
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }



