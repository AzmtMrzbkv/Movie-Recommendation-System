package RecS;

// this class is the controller

import RecS.Models.*;


import RecS.MongoReps.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static RecS.Utils.CsvReader.readMoviesCsv;

@RestController
@EnableMongoRepositories
public class App {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    // if movie title is specified it returns data for just one movie
    public List<Movies> listAllMovies() throws IOException {
        //check validity of name
        //to be implemented
        return movieRepository.findAll();
    }
}
