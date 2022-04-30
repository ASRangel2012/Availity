package Model;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

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


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("UserID='").append(UserID).append('\'');
        sb.append(", FirstName='").append(FirstName).append('\'');
        sb.append(", LastName='").append(LastName).append('\'');
        sb.append(", Version=").append(Version);
        sb.append(", InsuranceCompany='").append(InsuranceCompany).append('\'');
        sb.append('}');
        sb.append("\n");
        return sb.toString();
    }

}
