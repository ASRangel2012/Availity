package Driver;

import CSVHelperMethods.HelperMethod;
import CSVParser.EnrolleeCSVParser;
import CSVWriter.EnrolleeCSVWriter;
import LISP_Validator.LispValidatorUsingDeque;
import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static List<String> companyList = new ArrayList<String>();
    public static Map<String, User> userHashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

//        String testLispCodeMethod = "(* 2 (cos 0) (+ 4 6))";
//        String testLispCodeMethod2 = "5(+ 1 2)";
//        String testLispCodeMethod3 = "(pprint (string-upcase foo))";
//        String testLispCodeMethod4 = "(if x (format t \"yes\") (format t \"no\")))";
//        String testLispCodeMethod5 = "(* (+ 1 2) (- 3 4))";
//        String nestedLISP = "(defun print-list (list)" +
//                "  (dolist (i list)" +
//                "    (format t \"item: ~a~%\" i)))";
//        String nestedLisp2 = """
//                (defun read-lines (file)
//                  "Return a list of lines in FILE."
//                  (with-temp-buffer
//                    (insert-file-contents file)
//                    (split-string
//                     (buffer-string) "" t)))
//
//                (mapcar
//                 (lambda (x)
//                   (mapcar
//                    (lambda (y) (string-to-number y))
//                    (split-string x " ")))
//                 (read-lines "blob.txt"))\s""";
//
//        LispValidatorUsingDeque LISP = new LispValidatorUsingDeque();
//        System.out.println(LISP.isLISPCodeValid(testLispCodeMethod));
//        System.out.println(LISP.isLISPCodeValid(testLispCodeMethod2));
//        System.out.println(LISP.isLISPCodeValid(testLispCodeMethod3));
//        System.out.println(LISP.isLISPCodeValid(testLispCodeMethod4));
//        System.out.println(LISP.isLISPCodeValid(testLispCodeMethod5));
//        System.out.println(LISP.isLISPCodeValid(nestedLISP));
//        System.out.println(LISP.isLISPCodeValid(nestedLisp2));
//        System.out.println(LISP.isLISPCodeValid(null)); //checking for null string
//        System.out.println(LISP.isLISPCodeValid("")); //checking for empty string


        EnrolleeCSVParser CSVParser = new EnrolleeCSVParser();
        EnrolleeCSVWriter writer = new EnrolleeCSVWriter();
        HelperMethod helper = new HelperMethod();

        List<User> userList = CSVParser.readCSVFile(); // reads whole file

        helper.filterList(userList); //filters the null, empty fields
        userList.addAll(userHashMap.values());
        System.out.println(userList.size());
        System.out.println(userHashMap.values());
       companyList = helper.filerByInsuranceCompany(userList, companyList);
       companyList = companyList.stream().sorted().collect(Collectors.toList());

       System.out.println(companyList);
       System.out.println(userList.size());
       for(User user:userList){
           helper.mapCompanyToUser(user,userHashMap);
       }
       System.out.println(userHashMap);
    }


}
