/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import util.MyBSTree;

/**
 *
 * @author tiny
 */
public class ProductData {

  // Save product data
  public static void saveData(MyBSTree tree) {
    try {
      File file = new File("DATA.txt");
      if (!file.exists()) {
        file.createNewFile();
      }
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      oos.writeObject(tree);

      oos.close();
      fos.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  // Read product data
  public static MyBSTree readData() {
    MyBSTree tree = null;
    try {
      File file = new File("DATA.txt");
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(fis);

      tree = (MyBSTree) ois.readObject();

    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
      return tree;
    } catch (IOException ex) {
      ex.printStackTrace();
      return tree;
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      return tree;
    }
    return tree;
  }
}
