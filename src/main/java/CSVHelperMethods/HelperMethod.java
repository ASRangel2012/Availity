package CSVHelperMethods;

import Model.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;


public class HelperMethod {


    public List<User> filterList(List<User> userList) {
        //extract empty or null values
        userList.removeIf(Objects::isNull);
        userList.removeIf(user -> user.getUserID().compareToIgnoreCase("") == 0);
        userList.removeIf(user -> user.getFirstName().compareToIgnoreCase("") == 0);
        userList.removeIf(user -> user.getLastName().compareToIgnoreCase("") == 0);
        userList.removeIf(user -> user.getInsuranceCompany().compareToIgnoreCase("") == 0);
        return userList;
    }


    public List<String> filerByInsuranceCompany(List<User> userList, List<String> insuranceCompanies){
        for(User user: userList)
            if(!insuranceCompanies.contains(user.getInsuranceCompany()))
                insuranceCompanies.add(user.getInsuranceCompany());
        return insuranceCompanies;
    }

    public void mapCompanyToUser(User user, Map<String,User> userHashMap){


    }

}
