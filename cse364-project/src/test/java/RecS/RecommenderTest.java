package RecS;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecommenderTest {

    @Test
    public void testParseStringOccupation() {
        Recommender tester = new Recommender();
        assertEquals("result","", tester.parseStringOccupation(""));
        assertEquals("result", "1", tester.parseStringOccupation("academic"));
        assertEquals("result","1", tester.parseStringOccupation("educator"));
        assertEquals("result","4", tester.parseStringOccupation("grad student"));
        assertEquals("result","4", tester.parseStringOccupation("gradstudent"));
        assertEquals("result","-1", tester.parseStringOccupation("grastudent"));
        assertEquals("result","-1", tester.parseStringOccupation("fsfsfdwq"));
        assertEquals("result", "2", tester.parseStringOccupation("artist"));
        assertEquals("result", "3", tester.parseStringOccupation("admin"));
        assertEquals("result", "5", tester.parseStringOccupation("customerservice"));
        assertEquals("result", "6", tester.parseStringOccupation("doctor"));
        assertEquals("result", "7", tester.parseStringOccupation("executive"));
        assertEquals("result", "8", tester.parseStringOccupation("farmer"));
        assertEquals("result", "9", tester.parseStringOccupation("homemaker"));
        assertEquals("result", "10", tester.parseStringOccupation("K-12studio"));
        assertEquals("result", "11", tester.parseStringOccupation("lawyer"));
        assertEquals("result", "12", tester.parseStringOccupation("programmer"));
        assertEquals("result", "13", tester.parseStringOccupation("retired"));
        assertEquals("result", "14", tester.parseStringOccupation("sales"));
        assertEquals("result", "15", tester.parseStringOccupation("scientist"));
        assertEquals("result", "16", tester.parseStringOccupation("self-employed"));
        assertEquals("result", "17", tester.parseStringOccupation("engineer"));
        assertEquals("result", "18", tester.parseStringOccupation("tradesman"));
        assertEquals("result", "19", tester.parseStringOccupation("unemployed"));
        assertEquals("result", "20", tester.parseStringOccupation("writing"));
    }

    @Test
    public void testParseAge() {
        Recommender tester = new Recommender();
        assertEquals("-1", tester.parseAge("-2123"));
        assertEquals("-1", tester.parseAge("gradstud"));
        assertEquals("1", tester.parseAge("7"));
        assertEquals("45", tester.parseAge("45"));
        assertEquals("56", tester.parseAge("57"));
        assertEquals("-1", tester.parseAge("4294967326"));
    }


    @Test
    public void testIsOccupation(){
        Recommender tester = new Recommender();
        assertEquals("result", true, tester.isOccupation("academic"));
        assertEquals("result", true, tester.isOccupation(""));
        assertEquals("result", false, tester.isOccupation("academc"));
        assertEquals("result", true, tester.isOccupation("educator"));
        assertEquals("result", true, tester.isOccupation("gradstudent"));
        assertEquals("result", false, tester.isOccupation("programer"));
    }

    @Test
    public void testIsValidAge() {
        Recommender tester = new Recommender();
        assertEquals("result", true, tester.isValidAge("5"));
        assertEquals("result", true, tester.isValidAge("0"));
        assertEquals("result", true, tester.isValidAge("19"));
        assertEquals("result", true, tester.isValidAge("34"));
        assertEquals("result", true, tester.isValidAge("43"));
        assertEquals("result", true, tester.isValidAge("45"));
        assertEquals("result", true, tester.isValidAge("51"));
        assertEquals("result", false, tester.isValidAge("0x`"));
        assertEquals("result", true, tester.isValidAge("0"));
        assertEquals("result", true, tester.isValidAge("57"));
        assertEquals("result", false, tester.isValidAge("Ffsfs"));
        assertEquals("result", false, tester.isValidAge("-231"));
    }

    @Test
    public void testIsGender() {
        Recommender tester = new Recommender();
        assertEquals("result", true, tester.isGender("M"));
        assertEquals("result", false, tester.isGender("f"));
        assertEquals("result", true, tester.isGender("F"));
        assertEquals("result", false, tester.isGender(""));
    }

    @Test
    public void testIsValidInput() throws IOException {
        Recommender tester = new Recommender();

        assertEquals(true, tester.isValidInput("M","23", "doctor", ""));
        assertEquals(true, tester.isValidInput("", "", "executive", "comedy|horror"));
        assertEquals(false, tester.isValidInput("F", "", "e", ""));
        assertEquals(true, tester.isValidInput("F", "15", "college", "sci-fi"));
        assertEquals(true, tester.isValidInput("", "", "", "AdVenturE"));
        assertEquals(true, tester.isValidInput("", "", "", ""));
        assertEquals(false, tester.isValidInput("M", "1000", "sale", ""));
        assertEquals(true, tester.isValidInput("M", "0", "unemployed", "Romance"));
        assertEquals(false, tester.isValidInput("ad", "sdfs", "fds", ""));
        assertEquals(false, tester.isValidInput("M", "0", "unemployed", "Romanc"));
        assertEquals(true, tester.isValidInput("", "", "", "comedy|horror"));
    }

    @Test
    public void testIsGenre() throws IOException {
        Recommender tester = new Recommender();

        assertEquals(true, tester.isGenre("comedy|horror"));
        assertEquals(true, tester.isGenre("western|comedy"));
        assertEquals(true,tester.isGenre("drama|Thriller"));
        assertEquals(false, tester.isGenre("wesern"));
        assertEquals(true, tester.isGenre(""));

    }

    @Test
    public void testGradeMovies() throws IOException{
        Recommender tester = new Recommender();
        String[] a = {"", "", "", ""};
        assertNotNull(tester.gradeMovies(a));
        assertEquals(true, tester.gradeMovies(a).size() > 0);
        a = new String[]{"M", "23", "doctor", ""};
        assertNotNull(tester.gradeMovies(a));
        assertEquals(true, tester.gradeMovies(a).size() > 0);

    }

    @Test
    public void testPromoteFavGenre() {
        Recommender tester = new Recommender();
        String[] a = {"", "", "", ""};
        assertNotNull(tester.promoteFavGenre(tester.gradeMovies(a), "fantasy"));
        assertEquals(true, tester.promoteFavGenre(tester.gradeMovies(a), "sci-fi").size() > 0);
    }


    @Test
    public void getGenreByID() {
        assertEquals("Animation|Children's|Comedy", Recommender.getGenreByID("1"));
        assertEquals("Adventure|Children's|Fantasy", Recommender.getGenreByID("2"));
    }

    @Test
    public void getTitleByID() {
        assertEquals("Toy Story (1995)", Recommender.getTitleByID("1"));
        assertEquals("Jumanji (1995)", Recommender.getTitleByID("2"));
    }

    @Test
    public void getImdbByID() {
        assertEquals("https://www.imdb.com/title/tt0114709", Recommender.getImdbByID("1"));
        assertEquals("https://www.imdb.com/title/tt0113497", Recommender.getImdbByID("2"));
    }

    @Test
    public void limTop() {
        List<Movies> expected = new ArrayList<>();
        Movies movie1 = new Movies("Braveheart (1995)", "https://www.imdb.com/title/tt0112573", "Action|Drama|War");
        Movies movie2 = new Movies("Schindler's List (1993)", "https://www.imdb.com/title/tt0108052", "Drama|War");

        expected.add(movie1);
        expected.add(movie2);

        List<Movies> arr = Recommender.limitedTop(Recommender.gradeMovies(new String[]{"F", "25", "Grad student", "Action|War"}), 2);

        for(int i = 0; i < 2; i++){
            assertEquals(expected.get(i).getGenres(), arr.get(i).getGenres());
            assertEquals(expected.get(i).getTitle(), arr.get(i).getTitle());
            assertEquals(expected.get(i).getImdb(), arr.get(i).getImdb());
        }
    }

}