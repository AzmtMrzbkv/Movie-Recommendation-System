package RecS.Models;

public class Posters {
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
