package RecS.Models;

public class MovieRec {
    private final String title;
    private final String limit;

    public MovieRec(String title, String limit) {
        this.title = title;
        this.limit = limit;
    }

    public String getTitle() {
        return title;
    }

    public String getLimit() {
        return limit;
    }
}
