package CSVHelperMethods;

import Model.User;

import java.util.*;
import java.util.stream.Collectors;


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


    public List<String> filerByInsuranceCompany(List<User> userList, List<String> companyList) {
        for (User user : userList)
            if (!(companyList.contains(user.getInsuranceCompany())))
                companyList.add(user.getInsuranceCompany());
        return companyList;
    }

    public Map<String, User> mapCompanyToUser(User user, Map<String, User> userHashMap) {
        String key = user.getUserID() + user.getInsuranceCompany();
        User addUserWithLatestVersion = userHashMap.get(key);
        if (addUserWithLatestVersion != null && addUserWithLatestVersion.getVersion() < user.getVersion()) {
            userHashMap.replace(key, user);
        } else {
            userHashMap.put(key, user);
        }
        return userHashMap;
    }


}
