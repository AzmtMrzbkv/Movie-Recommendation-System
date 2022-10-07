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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

import static RecS.Utils.CsvReader.*;
import static RecS.Utils.Recommender.*;

@CrossOrigin(origins = "*")
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

        LOG.info("\n*************** Loading csv files to Mongo DB ... ***************");
        this.movieRepository.saveAll(readMoviesCsv());
        LOG.info("\n*************** Loading movies to Movies Mongo DB: Success ***************");
        this.ratingRepository.saveAll(readRatingsCsv());
        LOG.info("\n*************** Loading ratings to Ratings Mongo DB: Success ***************");
        this.userRepository.saveAll(readUsersCsv());
        LOG.info("\n*************** Loading users to Users Mongo DB: Success ***************");
    }

    @GetMapping("/movies")
    public List<Movies> listAllMovies(){
        //return all movies
        LOG.info("\n*************** Returning all movies ***************");
        return movieRepository.findAll();
    }

    @GetMapping("/users/recommendations")
    public List<Movies> recommendByUser(
            @RequestParam(value = "gender", defaultValue = "") String gender,
            @RequestParam(value = "age", defaultValue = "") String age,
            @RequestParam(value = "occupation", defaultValue = "") String occupation,
            @RequestParam(value = "genre", defaultValue = "") String genre,
            @RequestParam(value="limit", defaultValue = "10") int limit
    ){
        List<Users> userList = userRepository.findAll();
        List<Ratings> ratingList = ratingRepository.findAll();
        List<Movies> movieList = movieRepository.findAll();

        //Mojno proverkuu dobavit vot zdes

        UserRec user = new UserRec(gender, parseAge(age), parseStringOccupation(occupation.toLowerCase(Locale.ROOT)), genre);

        if (!user.getGenre().equals("")) return getMovies(limitedTop(promoteFavGenre(gradeMovies(user, userList, ratingList), user.getGenre(), movieList), 10));
        return getMovies(limitedTop(gradeMovies(user, userList, ratingList), limit));
    }

    @GetMapping("/movies/recommendations")
    public List<Movies> recommendByFavGenre(@RequestParam("title") String title, @RequestParam(value = "limit", defaultValue = "10") int limit){
        Movies movie = movieRepository.findByTitle(title);
        List<Users> userList = userRepository.findAll();
        List<Ratings> ratingList = ratingRepository.findAll();

        Optional<Users> user = userRepository.findById(posFanFromMovieID(movie.getMovieID(), ratingList));

        // What if there is no any user who rated this movie
        if(user.isPresent()) return getMovies(limitedTop(gradeMovies(new UserRec(user.get().getGender(), user.get().getAge(), user.get().getOccupation(), ""), userList, ratingList),limit));
        return getMovies(limitedTop(gradeMovies(new UserRec("", "", "", ""),userList, ratingList),limit));
    }

    // Returns a List of Movies given List of movieIDs
    public List<Movies> getMovies(List<String> movieIDs){
        List<Movies> movies = new ArrayList<>();
        for(String movieID: movieIDs){
            Optional<Movies> movie = movieRepository.findById(movieID);
            movie.ifPresent(movies::add);
        }
        return movies;
    }
}
