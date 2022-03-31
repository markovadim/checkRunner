package by.markov.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class InputDataParserTest {

    //    InputDataParser ip = Mockito.mock(InputDataParser.class);
    InputDataParser ip = new InputDataParser();

    String[] args = new String[]{"1-1", "3-2", "4-4", "5-1"};
    String[] argsWithException = new String[]{"1as51", "3*2", "4-4", "3e1"};
    ArrayList<Integer> ids;


    @Before
    public void init() throws Exception {
//        Mockito.when(ip.parseInputArguments(argsWithException)).thenReturn(new String[]{"1", "3", "4", "5"});
        ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(4);
        ids.add(5);
    }

    @Test
    public void parseInput() throws Exception {
        ip.parseInputArguments(args);
        assertEquals(ip.idsOfProducts, ids);
    }

//    @Test
//    public void parseInputWithException() throws NumberFormatException {
//        assertThrows(NumberFormatException.class, () -> ip.parseInputArguments(argsWithException));
//    }
}