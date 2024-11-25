package Library;

public class User {
    private String name;
    private int books_read = 0;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBooks_read() {
        return books_read;
    }

    public void setBooks_read(int books_read) {
        this.books_read = books_read;
    }
}
