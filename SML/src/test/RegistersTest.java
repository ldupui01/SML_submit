/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sml.Registers;

/**
 * @author Guilherme
 *
 */
public class RegistersTest {
    Registers r;
    @Before
    public void setUp() throws Exception{
        r = new Registers();
    }

    /*
     * assert constructor inits array at value 0 for every position.
     */
    @Test
    public final void testRegisters(){
        //setup
        int numberOfRegisters = 32;
        int expected = 0;
        //test
        for (int i = 0; i != numberOfRegisters; i++) {
            assertEquals(expected,r.getRegisters()[i]);
        }
    }
	/**
	 * Test method for {@link sml.Registers#setRegister(int, int)}.
	 */
	@Test
	public final void testSetRegister() {
		//setup
        int indexOfRegister = 7;
        //expected
        int expected = 45;
        //actual
        r.setRegister(indexOfRegister,expected);
        int actual =r.getRegister(indexOfRegister);
        //test
        assertEquals(expected,actual);
	}
    /**
     * Test method for {@link sml.Registers#setRegister(int, int)}.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public final void testSetRegisterThrowsException() {
        r.setRegister(45,6);
    }
	/**
	 * Test method for {@link sml.Registers#getRegister(int)}.
	 */
	@Test
	public final void testGetRegister() {
        //setup
        int indexOfRegister = 7;
        //expected
        int expected = 45;
        //actual
        r.setRegister(indexOfRegister,expected);
        int actual =r.getRegister(indexOfRegister);
        //test
        assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link sml.Registers#getRegisters()}.
	 */
	@Test
	public final void testGetRegisters() {
        //setup
        int numberOfRegisters = 32;
        int expected = 0;
        //test
        for (int i = 0; i != numberOfRegisters; i++) {
            assertEquals(expected,r.getRegisters()[i]);
        }
        //anotherTest
        //setup
        int indexOfRegister = 7;
        //expected
        expected = 45;
        //actual
        r.setRegister(indexOfRegister,expected);
        int actual =r.getRegisters()[indexOfRegister];
        //test
        assertEquals(expected,actual);
	}
}
