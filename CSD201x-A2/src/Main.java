
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

      switch (choise) {
        case 1:
          System.err.println("CASE 1");
          break;
        case 2:
          System.err.println("CASE 2");
          break;
        case 3:
          System.err.println("CASE 3");
          break;
        case 4:
          System.err.println("CASE 4");
          System.out.print("Book code: ");
          boolean validate = true;
          while (validate) {
            String bCode = s.nextLine();
            if (Validation.validateBCode(bCode)) {
              System.out.print("Book title: ");
              String title = s.nextLine();
              if (Validation.validateTitle(title)) {
                System.out.print("Quantity: ");
                int quantity = 0;
                quantity = Validation.validateIntNumber(quantity);
                System.out.print("Lended: ");
                int lended = 0;
                lended = Validation.validateIntNumber(lended);
                System.out.print("Price: ");
                double price = 0;
                price = Validation.validateDoubleNumber(price);
                validate = false;
              }
            }
          }

          bList.addFirst();
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
