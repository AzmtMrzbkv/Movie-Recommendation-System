package RecS.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
    @Id
    private final String userID;
    private final String gender;
    private final String age;
    private final String occupation;
    private final String zip;

    public Users(String userID, String gender, String age, String occupation, String zip) {
        this.userID = userID;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.zip = zip;
    }

    public Users(String gender, String age, String occupation) {
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.zip = null;
        this.userID = null;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getUserID() {
        return userID;
    }

    public String getZip() { return zip; }
}
