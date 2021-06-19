package RecS.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ratings {
    @Id
    private final String userID;
    private final String movieID;
    private final String rating;
    private final String timestamp;

    public Ratings(String userID, String movieID, String rating, String timestamp) {
        this.userID = userID;
        this.movieID = movieID;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public String getUserID() {
        return userID;
    }

    public String getMovieID() {
        return movieID;
    }

    public String getRating() {
        return rating;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
