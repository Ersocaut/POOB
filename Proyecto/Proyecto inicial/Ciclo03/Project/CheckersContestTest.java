

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CheckersContestTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CheckersContestTest
{
    /**
     * Default constructor for test class CheckersContestTest
     */
    public CheckersContestTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void Prueba_Arena()
    {
        CheckersContest checkers1 = new CheckersContest(8);
        assertEquals("-.-.-.-.\n.-.-.-.-\n-.-.-.-.\n.-.-.-.-\n-.-.-.-.\n.-.-.-.-\n-.-.-.-.\n.-.-.-.-\n", checkers1.write());
    }
}

