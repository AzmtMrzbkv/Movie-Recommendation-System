package RecS;

public class Movies {
    private final String title;
    private final String genres;
    private final String imdb;

    public Movies(String title, String id, String imdb, String genres) {
        this.title = title;
        this.imdb = imdb;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getImdb() {
        return imdb;
    }

    public String getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                ", imdb='" + imdb + '\'' +
                '}';
    }
}
