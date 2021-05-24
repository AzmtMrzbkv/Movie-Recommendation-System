package RecS;

// this class will be the controller

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class App {
    //here will be functions mapped to GET

    //this function return recommendation list
    @GetMapping("/users/recommendations ")
    public List<Movies> recommendForUser(@RequestBody Users newUser) {
        // this part to be implemented
        return null;
    }

    @GetMapping("/movies/recommendations ")
    public List<Movies> recommendByMovie(@RequestBody LimitedRec newRequest) {
        // this part to be implemented
        return null;
    }
}
