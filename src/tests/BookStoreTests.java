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
        books.add(new Book("FirstBook", 1));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        assertEquals(BookStore.fullBookPrice, price);
    }

    @Test
    public void twoDifferentBooksShouldBeDiscounted(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("FirstBook", 1));
        books.add(new Book("SecondBook", 2));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 1.9 * BookStore.fullBookPrice;
        assertEquals(correctPrice, price);
    }

    @Test
    public void threeDifferentBooksShouldBeDiscounted(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("FirstBook", 1));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("ThirdBook", 3));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 2.7 * BookStore.fullBookPrice;
        assertEquals(correctPrice, price);
    }

    @Test
    public void fourDifferentBooksShouldBeDiscounted(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("FirstBook", 1));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("ThirdBook", 3));
        books.add(new Book("FourthBook", 4));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 3.2 * BookStore.fullBookPrice;
        assertEquals(correctPrice, price);
    }

    @Test
    public void fiveDifferentBooksShouldBeDiscounted(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("FirstBook", 1));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("ThirdBook", 3));
        books.add(new Book("FourthBook", 4));
        books.add(new Book("FourthBook", 5));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 3.75 * BookStore.fullBookPrice;
        assertEquals(correctPrice, price);
    }

    @Test
    public void eightMixedBooksShouldReceivePartialDiscount(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("FirstBook", 1));
        books.add(new Book("FirstBook", 1));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("ThirdBook", 3));
        books.add(new Book("ThirdBook", 3));
        books.add(new Book("FourthBook", 4));
        books.add(new Book("FifthBook", 5));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 6.4 * BookStore.fullBookPrice;
        assertEquals(correctPrice, price);
    }

    @Test
    public void sixteenMixedBooksShouldReceivePartialDiscount(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("FirstBook", 1));
        books.add(new Book("FirstBook", 1));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("ThirdBook", 3));
        books.add(new Book("ThirdBook", 3));
        books.add(new Book("FourthBook", 4));
        books.add(new Book("FifthBook", 5));
        books.add(new Book("FirstBook", 1));
        books.add(new Book("FirstBook", 1));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("ThirdBook", 3));
        books.add(new Book("ThirdBook", 3));
        books.add(new Book("FourthBook", 4));
        books.add(new Book("FifthBook", 5));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 12.8 * BookStore.fullBookPrice;
        assertEquals(correctPrice, price);
    }

    @Test
    public void sixMixedBooksShouldReceivePartialDiscount(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("FirstBook", 1));
        books.add(new Book("FirstBook", 1));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("SecondBook", 2));
        books.add(new Book("ThirdBook", 3));
        books.add(new Book("FourthBook", 4));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = 3.2 * BookStore.fullBookPrice + 1.9 * BookStore.fullBookPrice;
        assertEquals(correctPrice, price);
    }

    @Test
    public void multipleEqualBooksShouldBeFullPrice(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("FirstBook", 1));
        books.add(new Book("FirstBook", 1));
        books.add(new Book("FirstBook", 1));
        books.add(new Book("FirstBook", 1));
        books.add(new Book("FirstBook", 1));
        BookStore store = new BookStore();
        double price = store.purchaseBooks(books);
        double correctPrice = books.size() * BookStore.fullBookPrice;
        assertEquals(correctPrice, price);
    }
}
