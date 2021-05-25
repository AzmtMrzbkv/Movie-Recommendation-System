package RecS;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoviesTest {

    @Test
    public void testGetTitle() {
        Movies movie = new Movies("Matrix, The (1999)", "https://www.imdb.com/title/tt0133093/", "Action|Sci-Fi|Thriller");
        assertEquals("Matrix, The (1999)", movie.getTitle());
    }

    @Test
    public void testGetImdb() {
        Movies movie = new Movies("Matrix, The (1999)", "https://www.imdb.com/title/tt0133093/", "Action|Sci-Fi|Thriller");
        assertEquals("https://www.imdb.com/title/tt0133093/", movie.getImdb());
    }

    @Test
    public void testGetGenres() {
        Movies movie = new Movies("Matrix, The (1999)", "https://www.imdb.com/title/tt0133093/", "Action|Sci-Fi|Thriller");
        assertEquals("Action|Sci-Fi|Thriller", movie.getGenres());
    }


    @Test
    public void testToString() {
        Movies movie = new Movies("Matrix, The (1999)", "https://www.imdb.com/title/tt0133093/", "Action|Sci-Fi|Thriller");
        assertEquals("Movies{" + "title='" + movie.getTitle() + '\'' + ", genres='" + movie.getGenres() + '\'' + ", imdb='" + movie.getImdb() + '\'' + '}', movie.toString());
    }
}