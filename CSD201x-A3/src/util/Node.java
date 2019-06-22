/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author tiny
 */
public class Node<T> implements Serializable {

  public T info;
  public Node<T> left, right;

  public Node() {
  }

  public Node(T info, Node<T> left, Node<T> right) {
    this.info = info;
    this.left = left;
    this.right = right;
  }

  public Node(T info) {
    this(info, null, null);
  }
}
