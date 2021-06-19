package RecS;

// this class is the controller

import RecS.Models.*;


import RecS.MongoReps.MovieRepository;
import RecS.MongoReps.RatingRepository;
import RecS.MongoReps.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static RecS.Utils.CsvReader.*;

@RestController
@EnableMongoRepositories
public class App {
    private final MovieRepository movieRepository;
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    public App(MovieRepository movieRepository, RatingRepository ratingRepository, UserRepository userRepository) throws IOException {
        this.movieRepository = movieRepository;
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;

        LOG.info("\nLoading csv files to Mongo DB ...");
        this.movieRepository.saveAll(readMoviesCsv());
        LOG.info("\nLoading movies to Movies Mongo DB: Success");
//        this.ratingRepository.saveAll(readRatingsCsv());
//        LOG.info("\nLoading ratings to Ratings Mongo DB: Success");
//        this.userRepository.saveAll(readUsersCsv());
//        LOG.info("\nLoading users to Users Mongo DB: Success");
    }

    @GetMapping("/movies")
    public List<Movies> listAllMovies() throws IOException {
        //return all movies
        LOG.info("\nReturning all movies");
        return movieRepository.findAll();
    }
}
