

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MatrizTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MatrizTest
{
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
    /*
    @Test
    public void ProbarLaListaDeMatrices()
    {
        int [][] test = [[[1,2],[2,3]],[[5,6],[4,8]]];
        Matriz matriz1 = new Matriz([[[1,2],[2,3]],[[5,6],[4,8]]]);
    }*/


    @Test
    public void deberiaCrearMatrizIdentidad()
    {
        Matriz matriz1 = new Matriz(5);
        assertEquals("[[1/1,0/1,0/1,0/1,0/1]\n[0/1,1/1,0/1,0/1,0/1]\n[0/1,0/1,1/1,0/1,0/1]\n[0/1,0/1,0/1,1/1,0/1]\n[0/1,0/1,0/1,0/1,1/1]]", matriz1.toString());
    }
    
}




