package store;

import books.Book;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    public static final double fullBookPrice = 8;

    public double purchaseBooks(List<Book> books) {
        double discountAmount = getTotalDiscount(books);
        return fullBookPrice * books.size() - discountAmount;
    }

    private double getTotalDiscount(List<Book> books) {
        List<Book> originalList = new ArrayList<Book>(books);
        double discountAmount = 0;
        while (originalList.size() > 1){
            List<Book> distinctBooks = getDistinctBooks(originalList);
            discountAmount += getQuantityDiscount(distinctBooks.size());
            for (Book book : distinctBooks){
                int duplicate = originalList.indexOf(book);
                originalList.remove(duplicate);
            }
        }
        double alternateDiscount = getAlternateDiscount(books);
        return alternateDiscount > discountAmount
                ? alternateDiscount
                : discountAmount;
    }

    private double getAlternateDiscount(List<Book> books){
        List<Book> originalList = new ArrayList<Book>(books);
        int numberOfSets = 0;
        int maxDistinctCount = 0;
        while (originalList.size() > 1){
            List<Book> distinctBooks = getDistinctBooks(originalList);
            int currentDistinctCount = distinctBooks.size();
            if (currentDistinctCount > maxDistinctCount) maxDistinctCount = currentDistinctCount;
            for (Book book : distinctBooks){
                int duplicate = originalList.indexOf(book);
                originalList.remove(duplicate);
            }
            numberOfSets += 1;
        }
        return numberOfSets == 0
        ? 0
        : getAlternateDiscountAmount(books.size(), numberOfSets);
    }

    private double getAlternateDiscountAmount(int bookCount, int numberOfSets){
        int averageCount = bookCount / numberOfSets;
        double averageDiscountAmount = 0;
        if (bookCount < averageCount * numberOfSets){
            averageDiscountAmount += getQuantityDiscount(averageCount) * (numberOfSets - 1);
            averageDiscountAmount += getQuantityDiscount(averageCount - 1);
        } else{
            averageDiscountAmount += getQuantityDiscount(averageCount) * numberOfSets;
        }
        return averageDiscountAmount;
    }

    private List<Book> getDistinctBooks(List<Book> books) {
        List<Book> distinctList = new ArrayList<Book>();
        for (Book book : books){
            if (!distinctList.contains(book))
                distinctList.add(book);
        }
        return distinctList;
    }

    private double getQuantityDiscount(int numberOfBooks) {
        double fullPrice = fullBookPrice * numberOfBooks;
        switch (numberOfBooks){
            case 5:
                return .25 * fullPrice;
            case 4:
                return .20 * fullPrice;
            case 3:
                return .10 * fullPrice;
            case 2:
                return .05 * fullPrice;
            default:
                return 0;
        }
    }
}
