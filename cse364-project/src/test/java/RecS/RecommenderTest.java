package RecS;

import static org.junit.Assert.*;
import org.junit.Test;

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
}