/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sml.*;

import java.io.File;

/**
 * @author Guilherme
 *
 */
public class TranslatorTest {

    private Translator t;
    String filename;
    MachineInterface m;

    @Before
    public void setUp() throws Exception {
        filename = "testMML.txt";
        t = new Translator(filename);
        m = new Machine();
    }

    /**
     * Test method for {@link sml.Translator#Translator(java.lang.String)}.
     */
    @Test
    public final void testTranslator() {
        File f = new File("src" + File.separator + filename);
        assertTrue(f.exists());
        assertTrue(t instanceof Translator);
    }

    /**
     * Test method for {@link sml.Translator#readAndTranslate(sml.Labels, java.util.ArrayList)}.
     */
    @Test
    public final void testReadAndTranslate() {
        Machine.main(new String[]{filename});
        assertTrue(t.readAndTranslate(m.getLabels(), m.getProg()));
    }

}