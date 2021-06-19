package RecS.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movies {
    @Id
    private final String movieID;
    private final String title;
    private final String genres;
    private final String posterLink;
    private final String imdbID;

    public Movies(String movieID, String title, String genres, String posterLink, String imdbID) {
        this.title = title;
        this.movieID = movieID;
        this.genres = genres;
        this.posterLink = posterLink;
        this.imdbID = imdbID;
    }

    public String getPosterLink() { return posterLink; }

    public String getImdbID() { return imdbID; }

    public String getMovieID() { return movieID; }

    public String getTitle() { return title; }

    public String getGenres() {
        return genres;
    }
}
