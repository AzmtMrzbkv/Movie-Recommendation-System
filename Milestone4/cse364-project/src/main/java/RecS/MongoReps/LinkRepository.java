package RecS.MongoReps;

import RecS.Models.Links;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface LinkRepository extends MongoRepository<Links, String> {
}
