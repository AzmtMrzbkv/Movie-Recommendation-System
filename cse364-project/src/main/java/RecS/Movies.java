package RecS;

public class Movies {
    private final String title;
    private final String id;
    private final String link;
    private double rating = -1;


    public Movies(String title, String id, String link) {
        this.title = title;
        this.id = id;
        this.link = link;
    }

    public Movies(String title, String id, String link, double rating) {
        this.title = title;
        this.id = id;
        this.link = link;
        this.rating = rating;
    }


    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating){
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
