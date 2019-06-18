
import com.entity.Book;
import com.model.BookData;
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
public class BookList {

  // A list of book
  private MyList books;

  Scanner s = new Scanner(System.in);

  private String bCode, title;
  private int quantity, lended, position;
  private double price;

  public MyList getBooks() {
    return books;
  }

  public BookList() {
    books = BookData.readData();
    if(books == null)
    {
      books= new MyList();
    }
  }

  // Accept information of a Book
  private Book getBook() {
    return new Book(bCode, title, quantity, lended, price);
  }

  // Accept and add a new Book to the end of book list
  public void addLast() {
    boolean validate = true;
    bCode = title = "";
    price = quantity = lended = 0;
    System.out.print("Book code: ");
    while (validate) {
      bCode = s.nextLine();
      if (Validation.validateBCode(bCode)) {
        if (books.checkBCode(bCode)) {
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
              System.err.println("Title must be required!");
              System.err.print("Input book title again: ");
            }
          }
        } else {
          System.err.println("Book code must be unique");
          System.out.print("Book code: ");
        }
      } else {
        System.err.println("Code must be required!");
        System.err.print("Input book code again: ");
      }
    }

    books.addLast(this.getBook());
    BookData.saveData(books);
  }

  // Output information of book list
  public void list() {
    if (books == null || books.isEmpty()) {
      System.err.println("Books list is empty...");
    } else {
      books.traverse();
    }
  }

  // Search book by book code
  public void search() {
    boolean validate = true;
    System.out.print("Book code for search: ");
    bCode = "";
    while (validate) {
      bCode = s.nextLine();
      if (Validation.validateBCode(bCode)) {
        books.search(bCode);
        validate = false;
      }
    }
    Node<Book> book = books.search(bCode);
    if (book == null) {
      System.err.println(bCode + " is not exist...");
    } else {
      System.out.println("Infomation of book code " + bCode);
      System.out.println(book.info.toString());
    }
  }

  // Accept and add a new Book to the begining of book list
  public void addFirst() {
    boolean validate = true;
    bCode = title = "";
    price = quantity = lended = 0;
    System.out.print("Book code: ");
    while (validate) {
      bCode = s.nextLine();
      if (Validation.validateBCode(bCode)) {
        if (books.checkBCode(bCode)) {
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
              System.err.println("Title must be required!");
              System.err.print("Input book title again: ");
            }
          }
        } else {
          System.err.println("Book code must be unique");
          System.out.print("Book code: ");
        }
      } else {
        System.err.println("Code must be required!");
        System.err.print("Input book code again: ");
      }
    }

    books.addFirst(this.getBook());
    BookData.saveData(books);
  }

  // Add a new Book after a position k
  public void addAfter() {
    boolean validate = true;
    bCode = title = "";
    price = quantity = lended = position = 0;
    System.out.print("Book code: ");
    while (validate) {
      bCode = s.nextLine();
      if (Validation.validateBCode(bCode)) {
        if (books.checkBCode(bCode)) {
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
              System.out.print("Enter adding position: ");
              position = Validation.validateIntNumber(position);
              validate = false;
            } else {
              System.err.println("Code must be required!");
              System.err.print("Input book title again: ");
            }
          }
        } else {
          System.err.println("Book code must be unique");
          System.out.print("Book code: ");
        }
      } else {
        System.err.println("Code must be required!");
        System.err.print("Input book code again: ");
      }
    }
    books.addAfter(this.getBook(), position);
    BookData.saveData(books);
  }

  // Delete a Book at position k
  public void deleteAt() {
    boolean validate = true;
    position = 0;
    while (validate) {
      System.out.print("Enter position to delete: ");
      position = Validation.validateIntNumber(position);
      validate = false;
    }
    books.deleteAt(position);
    BookData.saveData(books);
  }

  public void save() {
    BookData.saveData(books);
  }
}
