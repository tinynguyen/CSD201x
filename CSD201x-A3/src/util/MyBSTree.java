/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiny
 */
public class MyBSTree {

  //a root of tree
  Node<Product> root;

  public MyBSTree() {
    root = null;
  }

  //visit a node of a tree -> output information of visited node
  public void visit(Node<Product> p) {
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }

  //return true if tree is empty otherwise return false
  public boolean isEmpty() {
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }

  //inorder a tree
  public void inOrder() {
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }

  //count number of products
  public int count() {
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }
  //breadth-first traverse a tree

  public void BFT() {
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }

  //insert a new Product to a tree
  public void insert(Product product) {
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }

  //balance a tree
  //step 1: traverse inorder tree and copy all item on tree to an arraylist
  //step 2: insert all items of list to a tree
  private void buildArray(List<Node<Product>> list, Node<Product> p) {
    if (p == null) {
      return;
    }
    buildArray(list, p.left);
    list.add(p);
    buildArray(list, p.right);
  }

  //step 2:
  private void balance(List<Node<Product>> list, int f, int l) {
    if (f > l) {
      return;
    }
    int mid = (f + l) / 2;
    Node<Product> p = list.get(mid);
    insert(p.info);
    balance(list, f, mid - 1);
    balance(list, mid + 1, l);
  }

  public void balance() {
    List<Node<Product>> list = new ArrayList<>();
    buildArray(list, root);
    MyBSTree tree = new MyBSTree();
    tree.balance(list, 0, list.size() - 1);
    root = tree.root;
  }

  //search a Node of tree by product code
  //return null if given code does not exists
  public Node<Product> search(String code) {
    if (isEmpty()) {
      return null;
    }
    Node<Product> p = root;
    while (p != null) {
      if (p.info.getCode().equalsIgnoreCase(code)) {
        break;
      }
      if (p.info.getCode().compareToIgnoreCase(code) < 0) {
        p = p.right;
      } else {
        p = p.left;
      }
    }
    return p;
  }

  //delete a node by a given product code
  public void delete(String code) {
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }

}
