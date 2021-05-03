import static org.junit.Assert.*;
import org.junit.Test;
import recommend.Tops;

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
        assertEquals("result", true, tester.isValidAge("57"));
        assertEquals("result", false, tester.isValidAge("Ffsfs"));
        assertEquals("result", false, tester.isValidAge("-231"));
    }
}


// main
// printTop10
// movieIDs
// mapwithNewRat
// parseStringOccupation
// mapWithNewRatCat
// isValidInput
// isGenre
// isOccupation
// parseAge
// parseStringOccupation
