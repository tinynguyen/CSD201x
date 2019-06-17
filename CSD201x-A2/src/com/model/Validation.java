/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.Scanner;

/**
 *
 * @author tiny
 */
public class Validation {

  public static int validateIntNumber(int num) {
    Scanner s = new Scanner(System.in);
    boolean validate = true;
    while (validate) {
      if (s.hasNextInt()) {
        num = s.nextInt();
        validate = false;
      } else {
        System.err.print("Invalid number! Input again: ");
      }
      s.nextLine();
    }
    return num;
  }
  
  public static double validateDoubleNumber(double num)
  {
    Scanner s = new Scanner(System.in);
    boolean validate = true;
    while (validate) {
      if (s.hasNextDouble()) {
        num = s.nextDouble();
        validate = false;
      } else {
        System.err.print("Invalid number! Input again: ");
      }
      s.nextLine();
    }
    return num;
  }

  public static boolean validateBCode(String bCode) {
    if (bCode.trim().equals("") || bCode == null) {
      System.err.println("Code must be required!");
      System.err.print("Input book code again: ");
      return false;
    }
    return true;
  }

  public static boolean validateTitle(String title) {
    if (title.trim().equals("") || title == null) {
      System.err.println("Code must be required!");
      System.err.print("Input book code again: ");
      return false;
    }
    return true;
  }
}
