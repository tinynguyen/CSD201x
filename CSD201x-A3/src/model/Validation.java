/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
}
