package by.markov.services.receipts;

import by.markov.models.*;

import java.util.Date;

public class ReceiptPrinter {
    public final static String TABLE_TOP_BORDER = "______________________________________";
    public final static String TABLE_BOTTOM_BORDER = "======================================";

    public String printSupermarket(Supermarket supermarket) {
        return supermarket.toString();
    }

    public String printCashierWithInfo(Cashier cashier) {
        Date date = new Date();
        return String.format("%-25sDATE:%1td/%tm/%ty%n%35tH:%tM", cashier.getName() + "#" + cashier.getIdNumber(), date, date, date, date, date);
    }

    public String printShopBasket(ShopBasket shopBasket) {
        String output = String.format(TABLE_TOP_BORDER + "%n%-7s%10s%10s%10s%n%n", "QTY", "DESCRIPTION", "PRICE", "TOTAL");
        int i = 0;
        for (Products product : shopBasket.getProducts()) {
            if ((shopBasket.getAmount().get(i) >= 5) && (product.isDiscount())) {
                output += String.format("%-10d%5s%13.1f%10.1f%n", shopBasket.getAmount().get(i), product, product.getPrice(), product.getPrice() * 0.9 * shopBasket.getAmount().get(i));
            } else {
                output += String.format("%-10d%5s%13.1f%10.1f%n", shopBasket.getAmount().get(i), product, product.getPrice(), product.getPrice() * shopBasket.getAmount().get(i));
            }
            i++;
        }
        output += TABLE_BOTTOM_BORDER;
        return output;
    }

    public String printTotalSum(Receipt receipt) {
        String newReceipt = String.format("%-25s%13.1f%n", "TAXABLE TOT.: $", receipt.getTaxable());
        newReceipt += String.format("%-25s%13.1f%n", "VAT10%: $", receipt.getDiscount());
        newReceipt += String.format("%-25s%13.1f%n", "TOTAL: $", receipt.getSum());
        return newReceipt;
    }
}
