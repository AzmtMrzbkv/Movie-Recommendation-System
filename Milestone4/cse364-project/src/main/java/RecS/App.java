package RecS;

// this class is the controller

import RecS.Models.*;


import RecS.MongoReps.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final MovieRepository movieRepository;
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    public App(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // if movie title is specified it returns data for just one movie, otherwise all movies
    // to be implemented
    @GetMapping("/movies")
    public List<Movies> listAllMovies() throws IOException {
        //check validity of name
        //to be implemented

        //return all movies
        LOG.info("\nwe are here\n");
        //movieRepository.saveAll(readMoviesCsv());
        movieRepository.save(new Movies("id", "title", "genre"));
        LOG.info("\nwe passed it\n");
        return movieRepository.findAll();
    }
}
