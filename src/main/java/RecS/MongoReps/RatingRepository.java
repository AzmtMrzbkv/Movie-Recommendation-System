package RecS.MongoReps;

import RecS.Models.Ratings;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends MongoRepository<Ratings, String> {
}
