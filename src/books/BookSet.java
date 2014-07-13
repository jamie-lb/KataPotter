package books;

import java.util.HashSet;
import java.util.Set;

public class BookSet {

    private Set<Book> books = new HashSet<Book>();

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public boolean containsBook(Book book){
        return books.contains(book);
    }

    public Integer size(){
        return books.size();
    }

    public double getSetPrice(){
        return getFullPrice() - getQuantityDiscount();
    }

    private double getFullPrice(){
        double fullBookPrice = 8;
        return fullBookPrice * size();
    }

    private double getQuantityDiscount() {
        double fullPrice = getFullPrice();
        switch (size()){
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
