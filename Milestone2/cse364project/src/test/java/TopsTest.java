import static org.junit.Assert.*;
import org.junit.Test;
import recommend.Tops;

import java.io.IOException;

public class TopsTest {
    @Test
    public void testIsValidInput() {
        Tops tester = new Tops();


    }

    @Test
    public void testIsGender() {
        Tops tester = new Tops();
        assertEquals("result", true, tester.isGender("M"));
        assertEquals("result", false, tester.isGender("f"));
        assertEquals("result", true, tester.isGender("F"));
        assertEquals("result", false, tester.isGender(""));
    }

    @Test
    public void testIsValidAge() {
        Tops tester = new Tops();
        assertEquals("result", true, tester.isValidAge("5"));
        assertEquals("result", true, tester.isValidAge("0"));
        assertEquals("result", true, tester.isValidAge("19"));
        assertEquals("result", true, tester.isValidAge("34"));
        assertEquals("result", true, tester.isValidAge("45"));
        assertEquals("result", true, tester.isValidAge("51"));
        assertEquals("result", false, tester.isValidAge("0x`"));
        assertEquals("result", true, tester.isValidAge("0"));
        assertEquals("result", true, tester.isValidAge("57"));
        assertEquals("result", false, tester.isValidAge("Ffsfs"));
        assertEquals("result", false, tester.isValidAge("-231"));
    }


    @Test
    public void testIsOccupation(){
        Tops tester = new Tops();
        assertEquals("result", true, tester.isOccupation("academic"));
        assertEquals("result", true, tester.isOccupation(""));
        assertEquals("result", false, tester.isOccupation("academc"));
        assertEquals("result", true, tester.isOccupation("educator"));
        assertEquals("result", true, tester.isOccupation("gradstudent"));
        assertEquals("result", false, tester.isOccupation("programer"));
    }


    @Test
    public void testParseStringOccupation() {
        Tops tester = new Tops();
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
        Tops tester = new Tops();
        assertEquals("-1", tester.parseAge("-2123"));
        assertEquals("-1", tester.parseAge("gradstud"));
        assertEquals("1", tester.parseAge("7"));
        assertEquals("45", tester.parseAge("45"));
        assertEquals("56", tester.parseAge("57"));
    }

    //NOTFULL
    @Test
    public void testIsGenre() throws IOException {
        Tops tester = new Tops();

        assertEquals(true, tester.isGenre("comedy|horror"));
        assertEquals(true, tester.isGenre("western|comedy"));
        assertEquals(true,tester.isGenre("drama|Thriller"));
        assertEquals(false, tester.isGenre("wesern"));
    }

}


// main
// printTop10
// movieIDs
// mapwithNewRat
// parseStringOccupation ()
// mapWithNewRatCat
// isValidInput
// isGenre (~)
// isOccupation ()
// parseAge ()
// parseStringOccupation ()
