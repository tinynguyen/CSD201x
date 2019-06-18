/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.util.MyList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author tiny
 */
public class BookData {

  // Save book data
  public static void saveData(MyList books) {
    try {
      File file = new File("DATA.txt");
      if (!file.exists()) {
        file.createNewFile();
      }
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      oos.writeObject(books);

      oos.close();
      fos.close();
    } catch (IOException ex) {
    }
  }

  // Read book data
  public static MyList readData() {
    MyList books = null;
    try {
      File file = new File("DATA.txt");
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(fis);

      books = (MyList) ois.readObject();

    } catch (FileNotFoundException ex) {
      return books;
    } catch (IOException ex) {
      return books;
    } catch (ClassNotFoundException ex) {
      return books;
    }
    return books;
  }

}
