package com.files;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiny
 */
public class Main {

    //contains a list of MyFile
    private MyFile[] files;

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
    }

    //sort the list of files ascending by size (use insertion sort)
    public void insertionSort() {
        //do nothing if list of files is empty
        /*You should insert code for sorting here, you are going to sort the list of
        loaded files named "files" ascending by file size.*/
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

    public static void main(String[] args) {

    }
}
