
import entity.Product;
import java.io.Serializable;
import java.util.Scanner;
import model.ProductData;
import model.Validation;
import util.MyBSTree;
import util.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tiny
 */
public class MyProduct implements Serializable {

  Scanner s = new Scanner(System.in);

  private String code, name;
  private int quantity, saled;
  private double price;

  // A list of products
  MyBSTree tree;

  public MyProduct() {
    tree = ProductData.readData();
    if (tree == null) {
      tree = new MyBSTree();
    }
  }

  // Input and insert a new product to tree
  public void insert() {
    boolean validate = true;
    code = name = "";
    price = quantity = saled = 0;
    System.out.print("Product code: ");
    while (validate) {
      code = s.nextLine();
      if (Validation.validateString(code)) {
        System.out.print("Product name: ");
        while (validate) {
          name = s.nextLine();
          if (Validation.validateString(name)) {
            System.out.print("Quantity: ");
            quantity = Validation.validateIntNumber(quantity);
            System.out.print("Saled: ");
            saled = Validation.validateIntNumber(saled);
            System.out.print("Price: ");
            price = Validation.validateDoubleNumber(price);
            validate = false;
          } else {
            System.err.println("Name must be required!");
            System.err.print("Enter product name again: ");
          }
        }
      } else {
        System.err.println("Code must be required!");
        System.err.print("Enter product code again: ");
      }
    }
    tree.insert(new Product(code, name, quantity, saled, price));
  }

  // In-order traverse
  public void inOrder() {
    tree.inOrder();
  }

  // BFT a tree
  public void BFT() {
    tree.BFT();
  }

  // Search a product by product code
  public void search() {
    boolean validate = true;
    code = "";
    Node<Product> p = null;
    System.out.print("Product code to search: ");
    while (validate) {
      code = s.nextLine();
      if (Validation.validateString(code)) {
        p = tree.search(code);
        validate = false;
      } else {
        System.err.println("Code must be required!");
        System.err.print("Enter product code again: ");

      }
    }
    if (p != null) {
      System.out.println("Information of product code " + p.info.getCode());
      tree.visit(p);
    } else {
      System.err.println("The product code " + code + " is not exist!");
    }
  }

  // Delete a product by product code
  public void delete() {
    boolean validate = true;
    code = "";
    System.out.print("Product code to delete: ");
    while (validate) {
      code = s.nextLine();
      if (Validation.validateString(code)) {
        tree.delete(code);
        validate = false;
      } else {
        System.err.println("Code must be required!");
        System.err.print("Enter product code again: ");
      }
    }
  }

  // Simply balancing a tree
  public void balance() {
    tree.balance();
  }

  // Count the number of products in the tree
  public int size() {
    return tree.count();
  }

  // Save all product data
  public void save() {
    ProductData.saveData(tree);
  }

  // Find product by price
  public void findByPrice() {
    boolean validate = true;
    price = 0;
    System.out.println("Enter price you want to find: ");
    while(validate)
    {
      price = Validation.validateDoubleNumber(price);
      validate = false;
    }
    tree.findByPrice(price);
  }
}
