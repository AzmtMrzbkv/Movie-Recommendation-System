package RecS;

import org.junit.Test;

import static org.junit.Assert.*;

public class LimitedRecTest {

    @Test
    public void getTitle() {
        LimitedRec lr = new LimitedRec("Matrix, The (1999)", "10");
        assertEquals("Matrix, The (1999)", lr.getTitle());
    }

    @Test
    public void getLimit() {
        LimitedRec lr = new LimitedRec("Matrix, The (1999)", "10");
        assertEquals("10", lr.getLimit());
    }


}