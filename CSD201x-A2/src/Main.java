
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

      boolean validate = true;
      while (validate) {
        if (s.hasNextInt()) {
          choise = s.nextInt();
          System.out.println(choise);
          validate = false;
        } else {
          System.out.println("Error");
        }
        s.nextLine();
      }

      switch (choise) {
        case 1:
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        case 0:
          running = false;
          break;
      }
    }
  }
}
