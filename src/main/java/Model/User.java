package Model;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

/**
 * User Model class which represents Enrollee object
 * No constructor and binded columns with properties using OpenCSV
 */
public class User {

    @CsvBindByName(column = "User ID")
    private String UserID;
    @CsvBindByName(column = "First Name")
    private String FirstName;
    @CsvBindByName(column = "Last Name")
    private String LastName;
    @CsvBindByName(column =  "Version")
    private int Version;
    @CsvBindByName(column = "Insurance Company")
    private String InsuranceCompany;

/*
    Getters and Setters for User Object
 */
    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getVersion() {
        return Version;
    }

    public void setVersion(int version) {
        Version = version;
    }

    public String getInsuranceCompany() {
        return InsuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        InsuranceCompany = insuranceCompany;
    }

/*
    Get toString representation of object
 */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(" ").append(UserID).append('\'');
        sb.append(",").append(FirstName).append('\'');
        sb.append(",").append(LastName).append('\'');
        sb.append(",").append(Version);
        sb.append(",").append(InsuranceCompany);
        sb.append("\n");
        return sb.toString();
    }

}
