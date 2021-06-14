package RecS.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Posters {
    @Id
    private final String movieID;
    private final String link;

    public Posters(String movieID, String link) {
        this.movieID = movieID;
        this.link = link;
    }

    public String getMovieID() {
        return movieID;
    }

    public String getLink() {
        return link;
    }
}
