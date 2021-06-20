package RecS.MongoReps;

import RecS.Models.Movies;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movies, String> {
    @Query("{'title': ?0}")
    Movies findByTitle(String title);
}
