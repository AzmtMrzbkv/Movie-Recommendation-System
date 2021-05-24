package RecS;

public class Users {
    private final int age;
    private final char gender;
    private final String occupation;
    private final String id;
    private double similarity = 0;


    public Users(int age, char gender, String occupation, String id) {
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.id = id;
    }

    public Users(int age, char gender, String occupation, String id, double similarity) {
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.id = id;
        this.similarity = similarity;
    }


    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getId() {
        return id;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity){
        this.similarity = similarity;
    }
}
