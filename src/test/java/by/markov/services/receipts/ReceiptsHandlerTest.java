package by.markov.services.receipts;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptsHandlerTest {

    ReceiptsHandler receiptsHandler = Mockito.mock(ReceiptsHandler.class);

    File file = new File("user.dir", "fileFromTest.txt");

    FileWriter fileWriter = Mockito.mock(FileWriter.class);

    String check = "           CASH RECEIPT\n" +
            "          SUPERMARKET 123\n" +
            "    12, MILKYWAY Galaxy/Earth\n" +
            "        Tel :123-456-7890\n" +
            "\n" +
            "CASHIER#133              DATE:01/04/22\n" +
            "                                 00:21\n" +
            "______________________________________\n" +
            "QTY    DESCRIPTION     PRICE     TOTAL\n" +
            "\n" +
            "======================================\n" +
            "TAXABLE TOT.: $                    0,0\n" +
            "VAT10%: $                          0,0\n" +
            "TOTAL: $                           0,0\n";


    @Test
    public void writeInFile() throws IOException {
        Mockito.when(receiptsHandler.create()).thenReturn(file);
        Mockito.when(fileWriter.append(check)).thenReturn(fileWriter);
    }
}