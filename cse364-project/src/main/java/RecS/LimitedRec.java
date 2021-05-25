package RecS;

public class LimitedRec {
    private final String title;
    private final String limit;

    public LimitedRec(String title) {
        this.title = title;
        this.limit = "10";
    }

    public LimitedRec(String title, String limit) {
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
