/**
 * 
 */
package test;

import static org.junit.Assert.*;

//import com.sun.swing.internal.plaf.metal.resources.metal;
import org.junit.Before;
import org.junit.Test;

import sml.Machine;
import sml.Translator;

import java.io.File;

/**
 * @author Guilherme
 *
 */
public class MachineTest {
    private Machine m;

    @Before
    public void setUp() throws Exception{
        m = new Machine();
    }

	/**
	 * Test method for {@link sml.Machine#main(java.lang.String[])}.
	 */
	@Test(timeout = 1000)
	public final void testMain() {
		String[] textArray = new String[2];
		textArray[0] = "testMML.txt";
		Machine.main(textArray);
	}

	/**
	 * Test method for {@link sml.Machine#toString()}.
	 */
	@Test
	public final void testToString() {
        //setup
        String filePath = "testMML.txt";
        Translator t = new Translator(filePath);
        t.readAndTranslate(m.getLabels(),m.getProg());
        //expected
        String expected = "f0: lin register 20 value is 6\n" +
                "f1: lin register 21 value is 1\n" +
                "f2: lin register 22 value is 1\n" +
                "f3: mul 21 * 20 to 21\n" +
                "f4: sub 20 - 22 to 20\n" +
                "f5: bnz next label being called is f3 until register 20 is 0\n" +
                "f6: out print register: 21\n" +
                "f7: div 21 / 21 to 0\n" +
                "f8: add 21 + 21 to 1\n";
        //actual
        String actual = m.toString();
        //test
        assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link sml.Machine#execute()}.
	 */
	@Test
	public final void testExecute() {
        //setup
        String filePath = "testMML.txt";
        Translator t = new Translator(filePath);
        t.readAndTranslate(m.getLabels(), m.getProg());
        //exec
        m.execute();
        //expected
        String expected = "Registers(registers=[1, 1440, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 720, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0])";
       //actual
        String actual = m.getRegisters().toString();
        //test
        assertEquals(expected,actual);
    }
}
