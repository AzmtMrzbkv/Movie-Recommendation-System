package RecS.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Links {
    @Id
    private final String movieID;
    private final String imdbID;

    public Links(String movieID, String imdbID) {
        this.movieID = movieID;
        this.imdbID = imdbID;
    }

    public String getMovieID() {
        return movieID;
    }

    public String getImdbID() {
        return imdbID;
    }
}
