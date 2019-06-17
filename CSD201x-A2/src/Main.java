
import com.model.Validation;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tiny
 */
public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    BookList bList = new BookList();

    boolean running = true;
    while (running) {
      System.out.println("Book List");
      System.out.println("1. Input Book and add to the end");
      System.out.println("2. Display books");
      System.out.println("3. Search by code");
      System.out.println("4. Input Book and add to beginning");
      System.out.println("5. Add Book after position k");
      System.out.println("6. Delete Book at position k");
      System.out.println("0. Exit");
      System.out.print("Your choice: ");

      int choise = 0;
      choise = Validation.validateIntNumber(choise);

      boolean validate = true;
      String bCode;

      switch (choise) {
        // Add new book at last of books list
        case 1:
          bList.addLast();
          break;
        // Show all books  
        case 2:
          bList.list();
          break;
        // Search book by book code
        case 3:
          System.out.print("Book code for search: ");
          bCode = "";
          while (validate) {
            bCode = s.nextLine();
            if (Validation.validateBCode(bCode)) {
              bList.search(bCode);
              validate = false;
            }
          }
          break;
        // Add new book at begin of books list
        case 4:
          bList.addFirst();
          break;
        // Add new book at position k
        case 5:
          bList.addAfter();
          break;
        // Delete a book at position k
        case 6:
          bList.deleteAt();
          break;
        case 0:
          running = false;
          break;
      }
    }
  }
}
