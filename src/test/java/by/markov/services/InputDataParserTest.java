package by.markov.services;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class InputDataParserTest {

    InputDataParser ip;
    ArrayList<Integer> out;

    @Before
    public void createInstanceof() {
         ip = new InputDataParser();
    }


    @Test
    public void parseInputArguments() throws Exception {
        String[] input = ip.parseInputArguments(new String[]{"1-1", "2-2", "1-0", "8-8"});
        out = new ArrayList<>();
        out.add(1);
        out.add(2);
        out.add(1);
        out.add(8);
        assertEquals(ip.idsOfProducts, out);
    }

    @Test(expected = Exception.class)
    public void parseWithException() throws Exception {
        String[] input = ip.parseInputArguments(new String[]{"6543542-666", "2-2", "34-0", "8-8"});
        out = new ArrayList<>();
        out.add(1);
        out.add(2);
        out.add(1);
        out.add(8);
        assertNotEquals(ip.idsOfProducts, out);
    }
}