package com.dapster;

import Model.*;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Login loginObject;
    public static ProductManager catalog;
    public static void main(String[] args) {
	// write your code here
        loginObject = new Login();
        catalog = new ProductManager();
        while(true){
            System.out.println("*********************************************");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.println("*********************************************");
            System.out.print("Select Option : ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if(option==1)   Login();
            else if(option==2) SignUp();
            else break;
        }
    }
    public static void clearScreen() {
        //System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void Login(){
        clearScreen();
        System.out.println("User Type\n1. Admin\n2.Customer Login :");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if(option == 1){
            System.out.print("Enter your UserName :");
            String user = sc.next();
            /*Console console = System.console();
            if (console == null) {
                System.out.println("Couldn't get Console instance");
                System.exit(0);
            }
            String pass = new String(console.readPassword("Enter your password: "));
            */
            System.out.print("Enter your password: ");
            String pass = sc.next();
            Person person = loginObject.LoginCheck(user,pass,Login.UserType.Admin);
            if(person == null){
                System.out.println("Can't find username or password");
                return;
            }
            while(true){
                System.out.println("***************************************************");
                System.out.print("1. Product Add and Update Option\n2. Logout :");
                int input = sc.nextInt();
                if(input == 1){
                    showProductOption();
                }
                else {
                    System.out.println("Logging out");
                    break;
                }
            }
        }
        else if(option == 2){
            System.out.println("*****************************************************");
            System.out.println("Customer Portal Login");
            System.out.print("Enter your UserName :");
            String user = sc.next();
                /*Console console = System.console();
                if (console == null) {
                    System.out.println("Couldn't get Console instance");
                    System.exit(0);
                }
                String pass = new String(console.readPassword("Enter your password: "));
                */
            System.out.print("Enter your password: ");
            String pass = sc.next();
            Person person = loginObject.LoginCheck(user,pass,Login.UserType.User);
            if(person == null){
                System.out.println("Can't find username or password");
                return;
            }
            while(true){
                System.out.println("***************************************************");
                System.out.print("1. Buy Product\n2. Checkout\n3. Logout");
                int input = sc.nextInt();
                if(input == 1){
                    buyProduct((User)person);
                }
                else if(input == 2){
                    checkout((User)person);
                }
                else {
                    System.out.println("Logging out");
                    break;
                }
            }
        }
    }
    public static void SignUp(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Sign Up\nUserName : ");
        String userName,password,confirmPassword;
        userName = sc.nextLine();
        do{
            System.out.print("\nPassword :");
            password = sc.nextLine();
            System.out.print("Confirm Password :");
            confirmPassword = sc.nextLine();
        }while(password.compareTo(confirmPassword)!=0);
        Person user = loginObject.getUserManger().addNew(userName,password);
        if(user == null)
            System.out.println("UserName is already present please login " +
                    "or choose different UserName to SignUp");
        while(true){
            System.out.println("***************************************************");
            System.out.print("1. Buy Product\n2. Checkout\n3. Logout :");
            int input = sc.nextInt();
            if(input == 1){
                buyProduct((User)user);
            }
            else if(input == 2){
                checkout((User)user);
            }
            else {
                System.out.println("Logging out");
                break;
            }
        }
    }
    public static void buyProduct(User user){
        while(true){
            System.out.println("************************************************");
            System.out.print("1. Show Products\n2. Add Product to Cart\n3. Exit :");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            if(input == 1){
                catalog.browseProduct();
            }
            else if(input == 2){
                System.out.print("Enter Product Code : ");
                sc.nextLine();
                String code = sc.nextLine();
                int quantity=0;
                if(!catalog.checkProductCode(code)){
                    System.out.println("Invalid Code");
                }
                else {
                    System.out.print("Enter Quantity :");
                    quantity = sc.nextInt();
                    user.addItemToCart(code,quantity);
                }
            }
            else{
                System.out.println("Exiting Buy View");
                break;
            }
        }
    }
    public static void checkout(User user){
        float totalCost = catalog.checkOut(user.getCart().getCartList());
        System.out.print("\nWant to checkout\n1.Yes\n2.No :");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if(option == 1){
            System.out.println("*******************************************");
            System.out.println("Final Price Payble : "+ totalCost);
            System.out.println("*******************************************");
            user.clearCart();
        }
    }
    public static void showProductOption(){
        while(true){
            System.out.println("************************************************");
            System.out.print("1. Show Products\n2. Add Product to Catalog" +
                    "\n3. Delete Product form catalog\n4. Update Product Info\n5. Exit :");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            if(input == 1){
                catalog.browseProduct();
            }
            else if(input == 2){
                if(!catalog.addProduct())
                    System.out.println("Failed to add product please try again");
            }
            else if(input == 3){
                sc.nextLine();
                System.out.print("\nProduct Code want to remove :");
                String code = sc.nextLine();
                catalog.remove(code);
            }
            else if(input == 4){
                sc.nextLine();
                System.out.print("\nProduct Code want to update :");
                String code = sc.nextLine();
                if(catalog.checkProductCode(code)){
                    System.out.println("What do you want to update");
                    System.out.print("1.Name\n2.Weight\n3.Details\n4.Price :");
                    int option = sc.nextInt();
                    switch (option){
                        case 1:
                            System.out.print("Name : ");
                            String name = sc.nextLine();
                            catalog.getProductInstance(code).setName(name);
                            break;
                        case 2:
                            System.out.print("Weight : ");
                            float weight = sc.nextFloat();
                            catalog.getProductInstance(code).setWeight(weight);
                            break;
                        case 3:
                            System.out.print("Details : ");
                            String details = sc.nextLine();
                            catalog.getProductInstance(code).setDetail(details);
                            break;
                        case 4:
                            System.out.print("Price : ");
                            float price = sc.nextFloat();
                            catalog.getProductInstance(code).setPrice(price);
                            break;
                    }
                    System.out.println("Sucessfully Updated");
                }
                else {
                    System.out.println("Invalid Product code");
                }
            }
            else{
                System.out.println("Exiting Add Product to catalog view");
                break;
            }

        }
    }
}
