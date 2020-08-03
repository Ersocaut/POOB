
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CheckersTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CheckersTest
{
    /**
     * Default constructor for test class CheckersTest
     */
    public CheckersTest()
    {
    }

    @Test
    public void lasfichasnosepuedensalirdeltableroDL()
    {
        Checkers checkers1 = new Checkers(8);
        checkers1.add(true, 2, 3);
        checkers1.select(2, 3);
        checkers1.shift(true, true);
        checkers1.shift(true, true);
    }

    @Test
    public void deberiaguardaryrecuperartableroDL()
    {
        Checkers checkers1 = new Checkers(8);
        checkers1.add(true, 2, 3);
        checkers1.add(false, 3, 4);
        checkers1.save("johann gurrero");
        checkers1.removeP(2, 3);
        checkers1.removeP(3, 4);
        assertEquals("-.-.-.-.\n.-w-.-.-\n-.-w-.-.\n.-.-.-.-\n-.-.-.-.\n.-.-.-.-\n-.-.-.-.\n.-.-.-.-\n", checkers1.recover("johann gurrero"));
    }

    @Test
    public void elSaltoFuncionaDL()
    {
        Checkers checkers1 = new Checkers(8);
        checkers1.makeVisible();
        checkers1.add(false, 2, 3);
        checkers1.swap();
        checkers1.add(true , 4, 7);
        checkers1.select(2, 3);
        checkers1.move("left");
        checkers1.swap();
        checkers1.add(true, 3, 4);
        checkers1.add(false, 4, 5);
        checkers1.swap();
        checkers1.select(3, 4);
        checkers1.jump(false, true);
    }
    
    @Test
    public void Ciclo3()
    {
        Checkers checkers1 = new Checkers(8);
        checkers1.read("-b-.-.-. -b-.-.-.\n.-.-.-.- .-.-.-.-\n-.-.-.-. -.-.-.-.\nB-.-w-.- .-.-w-.-\n-.-.-W-. -.-.-.-.\nw-.-.-.- .-.-.-.-\n-.-w-w-. -.-.-.-W\n.-.-.-.- .-.-.-.-");
        checkers1.makeVisible();
        checkers1.save("tablero1");
        checkers1.removeP(4, 1);
        checkers1.removeP(1, 2);
        checkers1.select(6, 1);
        checkers1.makeVisible();
        checkers1.shift(true, true);
        checkers1.recover("tablero1");
        checkers1.makeVisible();
    }
    
    @Test
    public void Ciclo4()
    {
        Checkers checkers1 = new Checkers(8);
        checkers1.read("-b-.-.-.\n.-.-.-.-\n-.-.-.-.\nB-.-w-.-\n-.-.-W-.\nw-.-.-.-\n-.-w-w-.W\n.-.-.-.-/n");
        checkers1.makeVisible();
        checkers1.removeP(4, 1);
        System.out.println(checkers1.write());
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

    

    

}



