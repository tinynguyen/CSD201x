/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.entity.Book;
import java.io.Serializable;

/**
 *
 * @author tiny
 */
public class MyList implements Serializable {

  Node<Book> head, tail, sorted;

  // Ctor
  public MyList() {
    head = tail = null;
  }

  // Check if the list is empty or not
  public boolean isEmpty() {
    return head == null;
  }

  // Add a new Book to the end of list
  public void addLast(Book b) {
    Node<Book> node = new Node<>(b);
    if (head == null) {
      head = node;
      return;
    }
    node.next = null;
    tail = head;
    while (tail.next != null) {
      tail = tail.next;
    }
    tail.next = node;
    return;
  }

  // Add a new Book to the begining of list
  public void addFirst(Book b) {
    Node<Book> node = new Node<>(b);
    node.next = this.head;
    this.head = node;
  }

  // Output information of all books in the list
  public void traverse() {
    Node<Book> node = head;
    System.out.println(String.format("%-10s%-20s%-10s%-10s%-10s%-10s", "Code", "Title",
            "Quantity", "Lended", "Price", "Value"));
    while (node != null) {
      System.out.println(node.info.toString());
      node = node.next;
    }
  }

  // Return number of nodes/elements in the list
  public int size() {
    Node<Book> node = head;
    int count = 0;
    while (node != null) {
      count++;
      node = node.next;
    }
    return count;
  }

  // Return a Node at position k, starting position is 0
  public Node<Book> getNode(int k) {
    Node<Book> node = head;
    int flag = 0;
    while (node != null) {
      if (flag == k) {
        return node;
      }
      flag++;
      node = node.next;
    }
    assert (false);
    return null;
  }

  // Add a new book after a position k
  public void addAfter(Book b, int k) {
    Node<Book> prevNode = this.getNode(k);
    if (prevNode == null) {
      System.err.println("Can not add a new book after position " + k);
      return;
    }
    Node<Book> node = new Node<>(b);
    node.next = prevNode.next;
    prevNode.next = node;
    System.out.println("A new book has been added after " + k);
  }

  // Delete a book at position k
  public void deleteAt(int k) {
    if (head == null) {
      System.err.println("Books list is empty...");
      return;
    }

    Node<Book> temp = head;
    if (k == 0) {
      head = temp.next;
      System.out.println("Deleted a book at position" + k);
      return;
    }

    for (int i = 0; temp != null && i < k - 1; i++) {
      temp = temp.next;
    }

    if (temp == null || temp.next == null) {
      System.err.println("Position " + k + " is over size of book list");
      return;
    }

    Node<Book> node = temp.next.next;
    temp.next = node;
  }

  // Search a Node by a given book code
  public Node<Book> search(String bCode) {
    Node<Book> node = head;
    while (node != null) {
      if (node.info.getbCode().equals(bCode)) {
        return node;
      }
      node = node.next;
    }
    return null;
  }

  // Check book code is exist
  public boolean checkBCode(String bCode) {
    Node<Book> node = head;
    while (node != null) {
      if (node.info.getbCode().equalsIgnoreCase(bCode)) {
        return false;
      }
      node = node.next;
    }
    return true;
  }

  public void sort() {
    sorted = null;
    Node<Book> current = this.head;
    while (current != null) {
      // Store next for next iteration 
      Node<Book> next = current.next;
      // insert current in sorted linked list 
      sortedInsert(current);
      // Update current 
      current = next;
    }
    // Update head_ref to point to sorted linked list 
    head = sorted;
  }

  private void sortedInsert(Node<Book> newNode) {
    if (sorted == null || sorted.info.getPrice() >= newNode.info.getPrice()) {
      newNode.next = sorted;
      sorted = newNode;
    } else {
      Node<Book> current = sorted;
      while (current.next != null && current.next.info.getPrice() < newNode.info.getPrice()) {
        current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
    }
  }

}
