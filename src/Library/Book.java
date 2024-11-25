package Library;

public class Book {
    private String name;
    private String book_content;
    private int read_amount = 0;
    private String author;

    public Book(String name, String book_content, String author) {
        this.name = name;
        this.book_content = book_content;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getBook_content() {
        return book_content;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBook_content(String book_content) {
        this.book_content = book_content;
    }

    public int getRead_amount() {
        return read_amount;
    }

    public void setRead_amount(int read_amount) {
        this.read_amount = read_amount;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
