package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Project: Library
        Scanner scn = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        System.out.print("Enter your name: ");
        User user = new User(scn.nextLine());
        loop:
        while (true) {
            System.out.println("""
                    1) books
                    2) add a book
                    3) see amount of books I have read
                    4) exit""");
            System.out.print("Enter index: ");
            String input = scn.nextLine();
            switch (input) {
                case "1":
                    if (books.isEmpty()) {
                        System.out.println("there are no books in the library.\n");
                        break;
                    }
                    int i = 1;
                    for (Book book : books) {
                        System.out.println(i+") "+book.getName());
                        i++;
                    }
                    System.out.print("Choose a book by its index: ");
                    String index = scn.nextLine();
                    try {
                        Integer.parseInt(index);
                    } catch (Exception x) {
                        System.out.println("Invalid input, try again.\n");
                        break;
                    }
                    Book chosen_book = books.get(Integer.parseInt(index)-1);
                    System.out.println("""
                            1) content
                            2) amount of people who read it""");
                    System.out.println("Enter number: ");
                    String input1 = scn.nextLine();
                    if (input1.equals("2")) {
                        System.out.println(chosen_book.getRead_amount()+"\n");
                        break;
                    } else if (input1.equals("1")) {
                        String[] words_of_content = chosen_book.getBook_content().split(" ");
                        int index2 = 0;
                        System.out.println();
                        System.out.print(chosen_book.getName() + ":");
                        System.out.print("\n   ");
                        for (String content : words_of_content) {
                            if (content.isEmpty()) {
                                continue;
                            }
                            System.out.print(content + " ");
                            index2++;
                            if (index2 >= 16) {
                                index2 = 0;
                                System.out.println();
                            }
                        }
                        System.out.println("\n\n");
                        chosen_book.setRead_amount(chosen_book.getRead_amount() + 1);
                        user.setBooks_read(user.getBooks_read() + 1);
                        break;
                    } else {
                        System.out.println("Invalid input, try again.\n");
                        break;
                    }
                case "2":
                    System.out.print("Enter the name: ");
                    String name = scn.nextLine();
                    System.out.println("Enter the content: ");
                    String content = scn.nextLine();
                    Book created_book = new Book(name, content, user.getName());
                    books.add(created_book);
                    System.out.println(name+" has been added to the library.\n");
                    break;
                case "3":
                    System.out.println(user.getBooks_read()+"\n");
                    break;
                case "4":
                    break loop;
                default:
                    System.out.println("Invalid input, try again.\n");
            }
        }
    }
}
