package RecS;

public class Users {
    private final String gender;
    private final String age;
    private final String occupation;
    private final String genres; //favorite genre

    public Users(String gender, String age, String occupation, String genres) {
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.genres = genres;
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

    public String getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "Users{" +
                "gender=" + gender +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                ", genres=" + genres +
                '}';
    }
}
