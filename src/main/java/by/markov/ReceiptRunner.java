package by.markov;

import org.apache.log4j.Logger;
import by.markov.services.InputDataParser;

public class ReceiptRunner {

    static final Logger logger = Logger.getLogger(ReceiptRunner.class);

    public static void main(String[] args) throws Exception {
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
