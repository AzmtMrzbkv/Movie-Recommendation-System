package RecS.MongoReps;

import RecS.Models.Posters;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface PosterRepository extends MongoRepository<Posters, String> {

}
