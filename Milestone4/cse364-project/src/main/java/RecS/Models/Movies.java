package RecS.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movies {
    @Id
    private final String movieID;
    private final String title;
    private final String genres;

    public Movies(String movieID, String title, String genres) {
        this.title = title;
        this.movieID = movieID;
        this.genres = genres;
    }

    public String getMovieID() { return movieID; }

    public String getTitle() {
        return title;
    }

    public String getGenres() {
        return genres;
    }

    public String getImdb() {
        //to be implemented
        return null;
    }
}
