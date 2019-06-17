
import com.entity.Book;
import com.util.MyList;

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

  public MyList getBooks() {
    return books;
  }

  public BookList() {
    books = new MyList();
  }

  // Accept information of a Book
  private Book getBook() {

    return null;
  }

  // Accept and add a new Book to the end of book list
  public void addLast(Book b) {
    books.addLast(b);
  }

  // Output information of book list
  public void list() {
    if (books.isEmpty()) {
      System.out.println("Books list is empty...");
    } else {
      books.traverse();
    }
  }

  // Search book by book code
  public void search() {
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }

  // Accept and add a new Book to the begining of book list
  public void addFirst(Book b) {
    books.addFirst(b);
  }

  // Add a new Book after a position k
  public void addAfter() {
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }

  // Delete a Book at position k
  public void deleteAt() {
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }
}
