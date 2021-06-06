package RecS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @Test
    void getAge() {
        Users user = new Users("F","25", "Grad student", "Action|War");
        assertEquals("25", user.getAge());
    }

    @Test
    void getGender() {
        Users user = new Users("F","25", "Grad student", "Action|War");
        assertEquals("F", user.getGender());
    }

    @Test
    void getOccupation() {
        Users user = new Users("F","25", "Grad student", "Action|War");
        assertEquals("Grad student", user.getOccupation());
    }

    @Test
    void getGenres() {
        Users user = new Users("F","25", "Grad student", "Action|War");
        assertEquals("Action|War", user.getGenres());
    }

    @Test
    void testToString() {
        Users user = new Users("F","25", "Grad student", "Action|War");
        assertEquals("Users{" +
                "gender=" + user.getGender() +
                ", age=" + user.getAge() +
                ", occupation='" + user.getOccupation() + '\'' +
                ", genres=" + user.getGenres() +
                '}', user.toString());
    }
}