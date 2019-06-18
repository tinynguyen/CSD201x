/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.Serializable;

/**
 *
 * @author tiny
 * @param <T>
 */
public class Node<T> implements Serializable {

  public T info;
  public Node<T> next;

  public Node() {
  }

  public Node(T info, Node<T> next) {
    this.info = info;
    this.next = next;
  }

  public Node(T info) {
    this(info, null);
  }
}
