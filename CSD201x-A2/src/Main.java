
import com.model.Validation;

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
    BookList bList = new BookList();

    boolean running = true;
    while (running) {
      System.out.println("|------------------------------------|");
      System.out.println("|             Books List             |");
      System.out.println("|------------------------------------|");
      System.out.println("| 1. Input book and add to the end   |");
      System.out.println("| 2. Display books                   |");
      System.out.println("| 3. Search by code                  |");
      System.out.println("| 4. Input Book and add to beginning |");
      System.out.println("| 5. Add book after position k       |");
      System.out.println("| 6. Delete book at position k       |");
      System.out.println("| 7. Save Book list                  |");
      System.out.println("| 0. Exit                            |");
      System.out.println("|------------------------------------|");
      System.out.print("  Your choice: ".toUpperCase());

      int choise = 0;
      choise = Validation.validateIntNumber(choise);

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
          bList.search();
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
        // Save book data in text file
        case 7:
          bList.save();
          break;
        case 0:
          running = false;
          break;
      }
    }
  }
}
