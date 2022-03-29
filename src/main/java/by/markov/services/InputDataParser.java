package by.markov.services;

import by.markov.models.Card;
import by.markov.services.shopbaskets.ShopBasketCreator;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class InputDataParser {
    private Card card;
    private final String EXPECTED_CARD_NAME = "card";
    static final Logger logger = Logger.getLogger(InputDataParser.class);
    public ArrayList<Integer>idsOfProducts;

    public String[] parseInputArguments(String[] itemIds) throws Exception {
        ArrayList<Integer> parsedItemIds = new ArrayList<>();               // all numbers
        idsOfProducts = new ArrayList<>();      // Ids
        ArrayList<Integer> amountOfProducts = new ArrayList<>();     // amount

        // loop for input item Ids
        try {
            for (String str : itemIds) {
                String[] nums = str.split("-");

                for (String num : nums) {
                    //find card
                    if (num.equalsIgnoreCase(EXPECTED_CARD_NAME)) {
                        card = new Card(Integer.parseInt(nums[nums.length - 1]));
                        logger.info("The card with number " + Integer.parseInt(nums[nums.length - 1]) + " was found");
                        break;
                    } else {
                        parsedItemIds.add(Integer.parseInt(num));
                        logger.info("The number " + Integer.parseInt(num) + " was found");
                    }
                }
            }

            for (int i = 0; i < parsedItemIds.size(); i++) {
                if (i % 2 == 0) {
                    idsOfProducts.add(parsedItemIds.get(i));
                    logger.info("The product id " + parsedItemIds.get(i) + " was added");
                } else {
                    amountOfProducts.add(parsedItemIds.get(i));
                    logger.info("The amount of products " + parsedItemIds.get(i) + " was added");
                }
            }
        } catch (Exception e) {
            logger.error("Incorrect input. " + e.getMessage());
        }

        ShopBasketCreator shopBasketCreator = new ShopBasketCreator();
        shopBasketCreator.createShopBasket(idsOfProducts, amountOfProducts, card);

        return itemIds;
    }
}
