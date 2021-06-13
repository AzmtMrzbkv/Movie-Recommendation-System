package RecS.Models;

public class Links {
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
