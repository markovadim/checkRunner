package by.markov.services.receipts;

import by.markov.ReceiptRunner;
import by.markov.models.Cashier;
import by.markov.models.Receipt;
import by.markov.models.Supermarket;
import by.markov.services.cashiers.CashierCreator;
import by.markov.services.exceptions.CashierHandlerException;
import by.markov.services.supermarkets.SupermarketCreator;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptsHandler {
    public String printReceiptTitle() {
        return String.format("%23s",Receipt.TITLE);
    }

    public File create() throws IOException {
        File file = new File(System.getProperty("user.dir"), "Check.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public File write(Receipt receipt, File file) throws Exception {
        SupermarketCreator supermarketCreator = new SupermarketCreator();
        Supermarket supermarket = supermarketCreator.createDefaultSupermarket();

        CashierCreator cashierCreator = new CashierCreator();
        try{
            Cashier cashier = cashierCreator.create(CashierCreator.DEFAULT_CASHIER_NAME);
            ReceiptPrinter receiptPrinter = new ReceiptPrinter();
            FileWriter fileWriter = new FileWriter(file, false);

            fileWriter.append(printReceiptTitle() + '\n');
            fileWriter.append(receiptPrinter.printSupermarket(supermarket) + '\n');
            fileWriter.append(receiptPrinter.printCashierWithInfo(cashier) + '\n');
            fileWriter.append(receiptPrinter.printShopBasket(receipt.getShopBasket()) + '\n');
            fileWriter.append(receiptPrinter.printTotalSum(receipt));
            fileWriter.close();
        }catch (CashierHandlerException e){
            System.out.println(e.getMessage());
        }
        return file;
    }

    public void display(File file) {
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        try {
            desktop.open(file);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void getReceipt(Receipt receipt) throws Exception {
        ReceiptsHandler handler = new ReceiptsHandler();
        File file = handler.create();
        handler.write(receipt, file);
        if (!ReceiptRunner.isAppRunViaCommandLine){
            handler.display(file);
        }

    }
}
