package by.markov.services.receipts;

import by.markov.ReceiptRunner;
import by.markov.models.Cashier;
import by.markov.models.Receipt;
import by.markov.models.Supermarket;
import by.markov.services.cashiers.CashierCreator;
import by.markov.services.exceptions.CashierHandlerException;
import by.markov.services.mailsender.Sender;
import by.markov.services.supermarkets.SupermarketCreator;

import javax.mail.MessagingException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptsHandler {
    public String printReceiptTitle() {
        return String.format("%23s", Receipt.TITLE);
    }

    public File create() throws IOException {
        File file = new File(System.getProperty("user.dir"), "Check.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public File write(Receipt receipt, File file) throws MessagingException, IOException {
        SupermarketCreator supermarketCreator = new SupermarketCreator();
        Supermarket supermarket = supermarketCreator.createDefaultSupermarket();
        CashierCreator cashierCreator = new CashierCreator();
        StringBuilder messageToMail = new StringBuilder();
        try {
            Cashier cashier = cashierCreator.create(CashierCreator.DEFAULT_CASHIER_NAME);
            ReceiptPrinter receiptPrinter = new ReceiptPrinter();
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.append(printReceiptTitle()).append('\n')
                    .append(receiptPrinter.printSupermarket(supermarket)).append('\n')
                    .append(receiptPrinter.printCashierWithInfo(cashier)).append('\n')
                    .append(receiptPrinter.printShopBasket(receipt.getShopBasket())).append('\n')
                    .append(receiptPrinter.printTotalSum(receipt));
            fileWriter.close();
            messageToMail.append(printReceiptTitle()).append('\n')
                    .append(receiptPrinter.printSupermarket(supermarket)).append('\n')
                    .append(receiptPrinter.printCashierWithInfo(cashier)).append('\n')
                    .append(receiptPrinter.printShopBasket(receipt.getShopBasket())).append('\n')
                    .append(receiptPrinter.printTotalSum(receipt));
        } catch (CashierHandlerException | IOException e) {
            System.out.println(e.getMessage());
        }
        Sender sender = new Sender();
        sender.sendCheckToMail(messageToMail.toString());
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
        if (!ReceiptRunner.isAppRunViaCommandLine) {
            handler.display(file);
        }
    }
}
