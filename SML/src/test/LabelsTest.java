/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import sml.Labels;

/**
 * @author Guilherme
 *
 */
public class LabelsTest {
    Labels l;
    @Before
    public void setup() throws Exception{
        l = new Labels();
    }
	/**
	 * Test method for {@link sml.Labels#addLabel(java.lang.String)}.
	 */
	@Test
	public final void testAddLabel() {
        //expecteds
        String[] expecteds = setUpLabels();
        String newAddition = "L5";
        //actuals
        String[] actuals = l.getLabels().toArray(new String[0]);
        //test
        assertArrayEquals(expecteds,actuals);
        //new setup
        int expected = 4;
        int newLabelPosition = l.addLabel(newAddition);
        //new test => assert addLabel returns the new label's position.
        assertEquals(expected, newLabelPosition);
    }

    private String[] setUpLabels() {
        String[] expecteds = new String[]{"L1","L2","L3","L4"};
        //setup
        l.addLabel(expecteds[0]);
        l.addLabel(expecteds[1]);
        l.addLabel(expecteds[2]);
        l.addLabel(expecteds[3]);
        return expecteds;
    }

    /**
	 * Test method for {@link sml.Labels#indexOf(java.lang.String)}.
	 */
	@Test
	public final void testIndexOf() {
		//setup
        setUpLabels();
        String newLabel = "L5";
       //expected
        int expected = l.addLabel(newLabel);
        //actual
        int actual = l.indexOf(newLabel);
        //test
        assertEquals(expected,actual);
    }

	/**
	 * Test method for {@link sml.Labels#toString()}.
	 */
	@Test
	public final void testToString() {
        //setup
        setUpLabels();
        //expected
        String expected = "(L1, L2, L3, L4)";
        //actual
        String actual = l.toString();
        //debug
        System.out.println(l.toString());
        //test
        assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link sml.Labels#reset()}.
	 */
	@Test
	public final void testReset() {
		//setup
        l.reset();
        //expected
        int expected = 0;
        //actual
        int actual = l.getLabels().size();
        assertEquals(expected,actual);
    }

}
