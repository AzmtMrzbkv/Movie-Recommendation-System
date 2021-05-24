package RecS;

// this class will be the controller

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RestController
public class App {
    //here will be functions mapped to GET

    //this function return recommendation list
    @GetMapping("/users/recommendations ")
    public List<Movies> recommendForUser(@RequestBody Users newUser) throws IOException {
        // this part to be implemented
        String age = newUser.getAge();
        String genre = newUser.getGenres();
        String gender = newUser.getGender();
        String occupation = newUser.getOccupation();

        if (!Recommender.isValidInput(age, gender, occupation, genre)) { return null; }

        return null;
    }

    @GetMapping("/movies/recommendations ")
    public List<Movies> recommendByMovie(@RequestBody LimitedRec newRequest) {
        // this part to be implemented
        return null;
    }

}
