package store;

import books.Book;
import books.BookSet;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    public double purchaseBooks(List<Book> books) {
        double price = 0;
        List<BookSet> bookSets = createBookSets(books);
        if (bookSetsAreUnbalanced(bookSets))
            bookSets = balanceSets(bookSets);
        for (BookSet bookSet : bookSets){
            price += bookSet.getSetPrice();
        }
        return price;
    }

    private boolean bookSetsAreUnbalanced(List<BookSet> bookSets) {
        if (bookSets.size() == 1){
            return false;
        } else if (bookSets.size() == 2){
            BookSet first = bookSets.get(0);
            BookSet second = bookSets.get(1);
            return !(first.size() < 5 && second.size() < 5) && Math.abs(first.size() - second.size()) >= 2;
        } else{
            return true;
        }
    }

    private List<BookSet> balanceSets(List<BookSet> bookSets) {
        for (int i = 0; i <= bookSets.size() - 2; i++){
            BookSet first = bookSets.get(i);
            int firstSize = first.size();
            for (int j = i + 1; j <= bookSets.size() - 1; j++){
                BookSet second = bookSets.get(j);
                int secondSize = second.size() + 1;
                if (firstSize > secondSize){
                    moveBooks(first, second);
                    break;
                }
            }
        }
        return bookSets;
    }

    private void moveBooks(BookSet first, BookSet second) {
        for (int i = 1; i <= 5; i++){
            Book book = new Book(i);
            if (first.containsBook(book) && !second.containsBook(book)){
                first.removeBook(book);
                second.addBook(book);
                break;
            }
        }
    }

    private List<BookSet> createBookSets(List<Book> books) {
        List<BookSet> sets = new ArrayList<BookSet>();
        while (books.size() > 0){
            BookSet bookSet = new BookSet();
            List<Book> distinctBooks = getDistinctBooks(books);
            for (Book book : distinctBooks){
                bookSet.addBook(book);
                books.remove(book);
            }
            sets.add(bookSet);
        }
        return sets;
    }

    private List<Book> getDistinctBooks(List<Book> books) {
        List<Book> distinctList = new ArrayList<Book>();
        for (Book book : books){
            if (!distinctList.contains(book))
                distinctList.add(book);
        }
        return distinctList;
    }

}