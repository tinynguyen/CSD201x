package com.files;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tiny
 */
public class Main {

  //contains a list of MyFile
  private static MyFile[] files;

  //ctor
  public Main() {
    files = null;
  }

  //get information of all text files under given folder name
  public void loadFiles(String folder) {
    List<MyFile> listFiles = new ArrayList<>();
    loadFiles(folder, listFiles);
    files = listFiles.stream().toArray(MyFile[]::new);
  }

  public void loadFiles(String folder, List<MyFile> listFiles) {
    /*insert the code for listing all text files under given folder here*/
    File file = new File(folder);
    File[] files = file.listFiles();
    for (File f : files) {
      if (f.isFile()) {
        listFiles.add(new MyFile(f.getName(), f.length(), f.getAbsolutePath()));
      } else if (f.isDirectory()) {
        loadFiles(f.getPath(), listFiles);
      }
    }
  }

  //list information of all loaded files
  public void list(MyFile[] files) {
    if (files != null && files.length > 0) {
      //output heading
      System.out.println(String.format("%-20s%-10s", "Name", "Size(in byte)"));
      for (MyFile f : files) {
        System.out.println(f);
      }
    } else {
      System.out.println("List of files is empty...");
    }
  }

  //sort the list of files ascending by size (use selection sort)
  public void selectionSort() {

    /*You should insert code for sorting here, you are going to sort the list of
        loaded files named "files" ascending by file size.*/
    int min;
    for (int i = 0; i < files.length - 1; i++) {
      min = i;
      for (int j = i + 1; j < files.length; j++) {
        if (files[j].getSize() < files[min].getSize()) {
          min = j;
        }
      }
      if (min != i) {
        MyFile temp = files[i];
        files[i] = files[min];
        files[min] = temp;
      }
    }
  }

  //sort the list of files ascending by size (use insertion sort)
  public void insertionSort() {
    /*You should insert code for sorting here, you are going to sort the list of
        loaded files named "files" ascending by file size.*/
    int pos = 0;
    MyFile temp;
    for (int i = 1; i < files.length; i++) {
      temp = files[i];
      for (pos = i; (pos > 0) && (files[pos - 1].getSize() > temp.getSize()); pos--) {
        files[pos] = files[pos - 1];
      }
      files[pos] = temp;
    }
  }

  //sort and output sorted list of text files
  public void sort(SortType st) {
    if (st == SortType.INSERTTIONSORT) {
      insertionSort();
    } else if (st == SortType.SELECTIONSORT) {
      selectionSort();
    }
    //output result after sorting
    list(files);
  }

  //return true if given MyFile contains given keyword, otherwise return false
  public boolean searchFile(MyFile mf, String keyword) {
    if (!mf.getName().toLowerCase().endsWith(".txt")) {
      return false;
    }
    //read the content of mf and see if keyword is in the content of mf or not
    /*You can use LineNumberReader to read the content of given mf and check out if
        the content of given mf contains keyword. This function should return true if 
        the searching is found, otherwise return false*/
    throw new UnsupportedOperationException("Remove this line and implement your code here!");
  }

  //output information of all files which content has given keyword
  public void searchFile(String keyword) {
    //save all files which matched given keyword to the list and output the list
    List<MyFile> listFiles = new ArrayList<>();
    for (MyFile f : files) {
      if (searchFile(f, keyword)) {
        listFiles.add(f);
      }
    }
    MyFile[] foundFiles = listFiles.stream().toArray(MyFile[]::new);
    list(foundFiles);
  }

  public static int validateInputNumbers(boolean validate, int choise) {
    Scanner s = new Scanner(System.in);
    while (validate) {
      if (s.hasNextInt()) {
        choise = s.nextInt();
        validate = false;
      } else {
        System.err.print("Please input number: ");
      }
      s.nextLine();
    }
    return choise;
  }

  public static void main(String[] args) {
    Main main = new Main();
    boolean running = true;
    Scanner s = new Scanner(System.in);
    while (running) {
      System.out.println("Menu");
      System.out.println("1. Load files");
      System.out.println("2. Sort files");
      System.out.println("3. Search files");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");
      int choise = 0;
      boolean validate = true;

      choise = validateInputNumbers(validate, choise);

      validate = true;
      while (validate) {
        if (choise <= 3 && choise >= 0) {
          validate = false;
        } else {
          System.err.println("Input number is invalid");
          System.out.print("Enter your choice again: ");
          choise = validateInputNumbers(validate, choise);
        }
      }

      switch (choise) {
        case 1:
          System.out.print("Enter a folder: ");
          validate = true;
          while (validate) {
            String folder = s.nextLine();
            try {
              main.loadFiles(folder);
              main.list(files);
              validate = false;
            } catch (NullPointerException ex) {
              System.err.println("Directory is not exist");
              System.out.print("Enter a folder again: ");
            }
          }
          break;
        case 2:
          try {
            SortType st;
            System.out.println("Sort the list of files by using");
            System.out.println("1. Selection Sort");
            System.out.println("2. Inserttion Sort");
            System.out.print("Your choise: ");
            int sortChoise = 0;
            validate = true;
            sortChoise = validateInputNumbers(validate, sortChoise);

            validate = true;
            while (validate) {
              if (sortChoise == 1 || sortChoise == 2) {
                validate = false;
              } else {
                System.err.println("Input number is invalid");
                System.out.print("Enter your choice again: ");
                sortChoise = validateInputNumbers(validate, sortChoise);
              }
            }
            switch (sortChoise) {
              case 1:
                st = SortType.SELECTIONSORT;
                main.sort(st);
                break;
              case 2:
                st = SortType.INSERTTIONSORT;
                main.sort(st);
                break;
            }
          } catch (NullPointerException ex) {
            main.list(files);
          }
          break;
        case 3:
          String keyword = s.nextLine();
          main.searchFile(keyword);
          break;
        case 0:
          running = false;
      }
    }
  }
}
