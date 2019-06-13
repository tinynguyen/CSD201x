package com.files;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiny
 */
public class Main {

  // contains a list of MyFile
  private static MyFile[] files;

  // contructor
  public Main() {
    files = null;
  }

  // get information of all text files under given folder name
  public void loadFiles(String folder) {
    List<MyFile> listFiles = new ArrayList<>();
    loadFiles(folder, listFiles);
    files = listFiles.stream().toArray(MyFile[]::new);
  }

  public void loadFiles(String folder, List<MyFile> listFiles) {
    /* insert the code for listing all text files under given folder here */
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

  // list information of all loaded files
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

  // sort the list of files ascending by size (use selection sort)
  public void selectionSort() {
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

  // sort the list of files ascending by size (use insertion sort)
  public void insertionSort() {
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

  // sort the list of files ascending by size (use quick sort)
  public void quickSort(int left, int right) {
    if (left >= right) {
      return;
    }
    MyFile pivot = files[(left + right) / 2];
    int i = left, j = right;
    do {
      while (files[i].getSize() < pivot.getSize()) {
        i++;
      }
      while (files[j].getSize() > pivot.getSize()) {
        j--;
      }
      if (i <= j) {
        MyFile temp = files[i];
        files[i] = files[j];
        files[j] = temp;
        i++;
        j--;
      }
    } while (i < j);
    quickSort(left, j);
    quickSort(i, right);
  }

  // sort and output sorted list of text files
  public void sort(SortType st) {
    if (st == SortType.INSERTTIONSORT) {
      insertionSort();
    } else if (st == SortType.SELECTIONSORT) {
      selectionSort();
    } else if (st == SortType.QUICKSORT) {
      quickSort(0, files.length - 1);
    }
    // output result after sorting
    list(files);
  }

  // return true if given MyFile contains given keyword, otherwise return false 
  public boolean searchFile(MyFile mf, String keyword) throws IOException {
    if (!mf.getName().toLowerCase().endsWith(".txt")) {
      return false;
    }
    // read the content of mf and see if keyword is in the content of mf or not
    FileReader fr = null;
    LineNumberReader lnr = null;
    String str;

    try {
      // create new reader
      fr = new FileReader(mf.getFullPath());
      lnr = new LineNumberReader(fr);

      // read lines till the end of the stream
      while ((str = lnr.readLine()) != null) {
        // check keyword in str
        if (!str.contains(keyword)) {
          return false;
        }
      }

    } catch (Exception e) {
      // if any error occurs
      return false;
    } finally {
      // closes the stream and releases system resources
      if (fr != null) {
        fr.close();
      }
      if (lnr != null) {
        lnr.close();
      }
    }
    return true;
  }

  // output information of all files which content has given keyword
  public void searchFile(String keyword) throws IOException {
    // save all files which matched given keyword to the list and output the list
    List<MyFile> listFiles = new ArrayList<>();
    for (MyFile f : files) {
      if (searchFile(f, keyword)) {
        listFiles.add(f);
      }
    }
    MyFile[] foundFiles = listFiles.stream().toArray(MyFile[]::new);
    list(foundFiles);
  }

  // output content of the files
  public void viewFile(String title) throws IOException {
    List<MyFile> textFile = new ArrayList<>();
    for (MyFile f : files) {
      if (f.getName().toLowerCase().endsWith(".txt")) {
        textFile.add(f);
      }
    }
    boolean found = false;
    for (MyFile f : textFile) {
      if (f.getName().equals(title + ".txt")) {
        FileReader fr = null;
        LineNumberReader lnr = null;
        String str;

        try {
          // create new reader
          fr = new FileReader(f.getFullPath());
          lnr = new LineNumberReader(fr);

          System.out.println("Content file:");
          // read lines till the end of the stream
          while ((str = lnr.readLine()) != null) {
            System.out.println(str);
          }
        } catch (Exception ex) {
          // if any error occurs
          ex.printStackTrace();
        } finally {
          // closes the stream and releases system resources
          if (fr != null) {
            fr.close();
          }
          if (lnr != null) {
            lnr.close();
          }
        }
        found = true;
      }
    }
    if (!found) {
      System.out.println('"' + title + '"' + " is not exist in directory!");
    }
  }

  // validate choise value of menu
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
      System.out.println("|--------------------|");
      System.out.println("|     CSD201x-A1     |");
      System.out.println("|--------------------|");
      System.out.println("|        Menu        |");
      System.out.println("|   1. Load files    |");
      System.out.println("|   2. Sort files    |");
      System.out.println("|   3. Search files  |");
      System.out.println("|   4. View files    |");
      System.out.println("|   0. Exit          |");
      System.out.println("|--------------------|");
      System.out.print("Enter your choice: ");
      int choise = 0;
      boolean validate = true;

      choise = validateInputNumbers(validate, choise);

      validate = true;
      while (validate) {
        if (choise <= 4 && choise >= 0) {
          validate = false;
        } else {
          System.err.println("Input number is invalid");
          System.out.print("Enter your choice again: ");
          choise = validateInputNumbers(validate, choise);
        }
      }

      // choise value of menu
      switch (choise) {
        // load file option
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
        // sort file option
        case 2:
          try {
            SortType st;
            System.out.println("Sort the list of files by using");
            System.out.println("1. Selection Sort");
            System.out.println("2. Inserttion Sort");
            System.out.println("3. Quick Sort");
            System.out.print("Your choise: ");
            int sortChoise = 0;
            validate = true;
            sortChoise = validateInputNumbers(validate, sortChoise);

            validate = true;
            while (validate) {
              if (sortChoise == 1 || sortChoise == 2 || sortChoise == 3) {
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
              case 3:
                st = SortType.QUICKSORT;
                main.sort(st);
                break;
            }
          } catch (NullPointerException ex) {
            main.list(files);
          }
          break;
        // search file option
        case 3:
          System.out.print("Enter any keyword to search: ");
          String keyword = "";
          validate = true;
          while (validate) {
            keyword = s.nextLine();
            if (!keyword.trim().equals("")) {
              try {
                main.searchFile(keyword);
                validate = false;

              } catch (NullPointerException ex) {
                System.err.println("Please load files before search!");
                break;
              } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
              }
            } else {
              System.err.println("Keyword must be required!");
              System.out.print("Enter any keyword again: ");
            }
          }
          break;
        // view files option
        case 4:
          System.out.print("Enter any title of file: ");
          String title = "";
          validate = true;
          while (validate) {
            title = s.nextLine();
            if (!title.trim().equals("")) {
              try {
                main.viewFile(title);
                validate = false;
              } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
              }
            } else {
              System.err.println("Title must be required!");
              System.out.print("Enter any title again: ");
            }
          }
          break;
        // exit option
        case 0:
          running = false;
          break;
      }
    }
  }
}
