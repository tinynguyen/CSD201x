
import com.entity.Book;
import com.model.Validation;
import com.util.MyList;
import com.util.Node;
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
      String bCode, title;
      int quantity, lended;
      double price;
      switch (choise) {
        // Add book at last of books list
        case 1:
          System.out.print("Book code: ");
          bCode = title = "";
          price = quantity = lended = 0;
          while (validate) {
            bCode = s.nextLine();
            if (Validation.validateBCode(bCode)) {
              System.out.print("Book title: ");
              while (validate) {
                title = s.nextLine();
                if (Validation.validateTitle(title)) {
                  System.out.print("Quantity: ");
                  quantity = Validation.validateIntNumber(quantity);
                  System.out.print("Lended: ");
                  lended = Validation.validateIntNumber(lended);
                  System.out.print("Price: ");
                  price = Validation.validateDoubleNumber(price);
                  validate = false;
                } else {
                  System.err.println("Code must be required!");
                  System.err.print("Input book title again: ");
                }
              }
            } else {
              System.err.println("Code must be required!");
              System.err.print("Input book code again: ");
            }
          }
          bList.addLast(new Book(bCode, title, quantity, lended, price));
          break;
        // Show all books  
        case 2:
          bList.list();
          break;
          // Search book by book code
        case 3:
          System.out.print("Book code for search: ");
          bCode = title = "";
          while (validate) {
            bCode = s.nextLine();
            if (Validation.validateBCode(bCode)) {
              bList.search(bCode);
              validate = false;
            }
          }
          break;
        // Add book at begin of books list
        case 4:
          System.out.print("Book code: ");
          bCode = title = "";
          price = quantity = lended = 0;
          while (validate) {
            bCode = s.nextLine();
            if (Validation.validateBCode(bCode)) {
              System.out.print("Book title: ");
              while (validate) {
                title = s.nextLine();
                if (Validation.validateTitle(title)) {
                  System.out.print("Quantity: ");
                  quantity = Validation.validateIntNumber(quantity);
                  System.out.print("Lended: ");
                  lended = Validation.validateIntNumber(lended);
                  System.out.print("Price: ");
                  price = Validation.validateDoubleNumber(price);
                  validate = false;
                } else {
                  System.err.println("Code must be required!");
                  System.err.print("Input book title again: ");
                }
              }
            } else {
              System.err.println("Code must be required!");
              System.err.print("Input book code again: ");
            }
          }
          bList.addFirst(new Book(bCode, title, quantity, lended, price));
          break;
        case 5:
          System.err.println("CASE 5");
          break;
        case 6:
          System.err.println("CASE 6");
          break;
        case 0:
          running = false;
          break;
      }
    }
  }
}
