package RecS;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MoviesTest {

    @Test
    public void getTitle() {
        Movies movie = new Movies("Matrix, The (1999)", "https://www.imdb.com/title/tt0133093/", "Action|Sci-Fi|Thriller");
        assertEquals("Matrix, The (1999)", movie.getTitle());
    }

    @Test
    public void getImdb() {
        Movies movie = new Movies("Matrix, The (1999)", "https://www.imdb.com/title/tt0133093/", "Action|Sci-Fi|Thriller");
        assertEquals("https://www.imdb.com/title/tt0133093/", movie.getImdb());
    }

    @Test
    public void getGenres() {
        Movies movie = new Movies("Matrix, The (1999)", "https://www.imdb.com/title/tt0133093/", "Action|Sci-Fi|Thriller");
        assertEquals("Action|Sci-Fi|Thriller", movie.getGenres());
    }
}