package RecS.Models;

public class UserRec {
    private final String gender;
    private final String age;
    private final String occupation;
    private final String genre;

    public UserRec(String gender, String age, String occupation, String genre) {
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.genre = genre;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getGenre() {
        return genre;
    }
}
