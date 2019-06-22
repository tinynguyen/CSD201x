
import model.Validation;

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

    MyProduct p = new MyProduct();

    boolean running = true;
    while (running) {
      System.out.println("|------------------------------------|");
      System.out.println("|            Product List            |");
      System.out.println("|------------------------------------|");
      System.out.println("| 1. Insert a new product            |");
      System.out.println("| 2. In-order traverse               |");
      System.out.println("| 3. Breadth first  traverse         |");
      System.out.println("| 4. Search by a product code        |");
      System.out.println("| 5. Delete by a product code        |");
      System.out.println("| 6. Simple balancing                |");
      System.out.println("| 7. Count number of products        |");
      System.out.println("| 8. Save all products               |");
      System.out.println("| 0. Exit                            |");
      System.out.println("|------------------------------------|");
      System.out.print("  Your choice: ".toUpperCase());

      int choise = 0;
      choise = Validation.validateIntNumber(choise);

      switch (choise) {
        case 1:
          System.err.println("CASE 1");
          p.insert();
          break;
        case 2:
          System.err.println("CASE 2");
          p.inOrder();
          break;
        case 3:
          System.err.println("CASE 3");
          p.BFT();
          break;
        case 4:
          System.err.println("CASE 4");
          p.search();
          break;
        case 5:
          System.err.println("CASE 5");
          p.delete();
          break;
        case 6:
          System.err.println("CASE 6");
          p.balance();
          break;
        case 7:
          System.err.println("CASE 7");
          p.size();
          break;
        case 8:
          System.err.println("CASE 8");
          p.save();
          break;
        case 0:
          running = false;
          break;
      }
    }
  }
}
