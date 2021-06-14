package RecS.MongoReps;

import RecS.Models.Movies;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movies, String> {
}
