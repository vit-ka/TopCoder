import java.util.*;
import java.math.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.*;

public class VendingMachine {
	
	public int motorUse(String[] prices, String[] purchases) {

        List<Purchase> parsedPurchases = parsePurchases(purchases);
        List<Shelf> parsedShelfs = parseShelfs(prices);

        int theMostExpensiveColumnId = findTheMostExpensiveColumnId(parsedShelfs);
        int currentIndex = 0;
        int columnCount = parsedShelfs.get(0).prices.length;

        int totalTime = findTimeToRotate(currentIndex, theMostExpensiveColumnId, columnCount);
        int lastBuyTime = 0;
        currentIndex = theMostExpensiveColumnId;

        for (Purchase purchase : parsedPurchases) {
            int timeToRotateToPurchase = 0;

            if (purchase.time - lastBuyTime >= 5) {
                theMostExpensiveColumnId = findTheMostExpensiveColumnId(parsedShelfs);
                timeToRotateToPurchase += findTimeToRotate(currentIndex, theMostExpensiveColumnId, columnCount);
                currentIndex = theMostExpensiveColumnId;
            }

            timeToRotateToPurchase += findTimeToRotate(currentIndex, purchase.column, columnCount);
            lastBuyTime = purchase.time;
            currentIndex = purchase.column;

            if (parsedShelfs.get(purchase.shelf).prices[purchase.column] == 0)
                return -1;

            parsedShelfs.get(purchase.shelf).prices[purchase.column] = 0;

            totalTime += timeToRotateToPurchase;
        }

        theMostExpensiveColumnId = findTheMostExpensiveColumnId(parsedShelfs);
        totalTime += findTimeToRotate(currentIndex, theMostExpensiveColumnId, columnCount);

		return totalTime;
	}

    private int findTimeToRotate(int fromIndex, int toIndex, int totalCount) {
        if (fromIndex > toIndex) {
            int temp = fromIndex;
            fromIndex = toIndex;
            toIndex = temp;
        }

        int timeToRotateCw = toIndex - fromIndex;
        int timeToRotateCcw = fromIndex + totalCount - toIndex;

        return min(timeToRotateCcw, timeToRotateCw);
    }

    private int findTheMostExpensiveColumnId(List<Shelf> shelfs) {
        int columnCount = shelfs.get(0).prices.length;
        int[] columnPrices = new int[columnCount];

        for (int i = 0; i < columnCount; ++i) {
             for (Shelf shelf : shelfs) {
                 columnPrices[i] += shelf.prices[i];
             }
        }

        int theMax = -1;
        int theMaxIndex = -1;

        for (int i = 0; i < columnCount; ++i) {
            if (columnPrices[i] > theMax) {
                theMax = columnPrices[i];
                theMaxIndex = i;
            }
        }

        return theMaxIndex;
    }

    private List<Shelf> parseShelfs(String[] prices) {
        List<Shelf> result = new ArrayList<Shelf>();

        for (String shelfPrices : prices) {
            String[] splittedShelfPrices = shelfPrices.split(" ");
            Shelf shelf = new Shelf();
            shelf.prices = new int[splittedShelfPrices.length];

            int index = 0;
            for (String splittedShelfPrice : splittedShelfPrices) {
                shelf.prices[index++] = Integer.valueOf(splittedShelfPrice);
            }

            result.add(shelf);
        }

        return result;
    }

    private List<Purchase> parsePurchases(String[] purchases) {
        List<Purchase> result = new ArrayList<Purchase>();

        Pattern purchasePattern = Pattern.compile("(?<shelf>\\d+),(?<column>\\d+):(?<time>\\d+)");

        for (String purchaseStr : purchases) {
            Purchase purchase = new Purchase();

            Matcher matcher = purchasePattern.matcher(purchaseStr);
            if (matcher.find()) {
                purchase.shelf = Integer.valueOf(matcher.group("shelf"));
                purchase.column = Integer.valueOf(matcher.group("column"));
                purchase.time = Integer.valueOf(matcher.group("time"));

                result.add(purchase);
            }

        }

        return result;
    }

    private static class Purchase {
        public int shelf;
        public int column;
        public int time;
    }

    private static class Shelf {
        public int[] prices;
    }
}
