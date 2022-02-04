package by.markov;

import org.apache.log4j.Logger;
import by.markov.services.InputDataParser;

import java.io.Console;

public class ReceiptRunner {

    static final Logger logger = Logger.getLogger(ReceiptRunner.class);
    public static boolean isAppRunViaCommandLine = false;

    public static void main(String[] args) throws Exception {
        Console console = System.console();
        if (console != null || args.length > 0) {
            isAppRunViaCommandLine = true;
        }

        InputDataParser inputDataParser = new InputDataParser();
        try {
            logger.info("Parse input line");
            inputDataParser.parseInputArguments(args);
//            inputDataParser.parseInputArguments(new String[]{"1-6", "2-2", "3-1", "4-2", "5-5", "6-1", "card-1221"});
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
