package tests;

import books.Book;
import org.junit.Test;
import store.BookStore;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class BookStoreTests {

    @Test
    public void oneBookShouldBeFullPrice(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        assertEquals(8.0, price);
    }

    @Test
    public void twoDifferentBooksShouldBeDiscounted(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1));
        books.add(new Book(2));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 1.9 * 8.0;
        assertEquals(correctPrice, price);
    }

    @Test
    public void threeDifferentBooksShouldBeDiscounted(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1));
        books.add(new Book(2));
        books.add(new Book(3));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 2.7 * 8.0;
        assertEquals(correctPrice, price);
    }

    @Test
    public void fourDifferentBooksShouldBeDiscounted(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1));
        books.add(new Book(2));
        books.add(new Book(3));
        books.add(new Book(4));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 3.2 * 8.0;
        assertEquals(correctPrice, price);
    }

    @Test
    public void fiveDifferentBooksShouldBeDiscounted(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1));
        books.add(new Book(2));
        books.add(new Book(3));
        books.add(new Book(4));
        books.add(new Book(5));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 3.75 * 8.0;
        assertEquals(correctPrice, price);
    }

    @Test
    public void eightMixedBooksShouldReceivePartialDiscount(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(2));
        books.add(new Book(2));
        books.add(new Book(3));
        books.add(new Book(3));
        books.add(new Book(4));
        books.add(new Book(5));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 6.4 * 8.0;
        assertEquals(correctPrice, price);
    }

    @Test
    public void sixteenMixedBooksShouldReceivePartialDiscount(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(2));
        books.add(new Book(2));
        books.add(new Book(2));
        books.add(new Book(2));
        books.add(new Book(3));
        books.add(new Book(3));
        books.add(new Book(3));
        books.add(new Book(3));
        books.add(new Book(4));
        books.add(new Book(4));
        books.add(new Book(5));
        books.add(new Book(5));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 12.8 * 8.0;
        assertEquals(correctPrice, price);
    }

    @Test
    public void sixMixedBooksShouldReceivePartialDiscount(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(2));
        books.add(new Book(2));
        books.add(new Book(3));
        books.add(new Book(4));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 3.2 * 8.0 + 1.9 * 8.0;
        assertEquals(correctPrice, price);
    }

    @Test
    public void multipleEqualBooksShouldBeFullPrice(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(1));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 40.0;
        assertEquals(correctPrice, price);
    }

    @Test
    public void twentyThreeMixedShouldReceivePartialDiscount(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(1));
        books.add(new Book(2));
        books.add(new Book(2));
        books.add(new Book(2));
        books.add(new Book(2));
        books.add(new Book(2));
        books.add(new Book(3));
        books.add(new Book(3));
        books.add(new Book(3));
        books.add(new Book(3));
        books.add(new Book(4));
        books.add(new Book(4));
        books.add(new Book(4));
        books.add(new Book(4));
        books.add(new Book(4));
        books.add(new Book(5));
        books.add(new Book(5));
        books.add(new Book(5));
        books.add(new Book(5));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 11.25 * 8.0 + 6.4 * 8.0;
        assertEquals(correctPrice, price);
    }
}
