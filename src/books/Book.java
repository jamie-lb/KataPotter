package books;

public class Book {
    private final String title;
    private final int id;

    public Book(String bookTitle, int seriesId) {
        title = bookTitle;
        id = seriesId;
    }

    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other.getClass() != Book.class) return false;
        Book otherBook = (Book)other;
        return this.equals(otherBook);
    }

    private boolean equals(Book other){
        return id == other.id;
    }
}
