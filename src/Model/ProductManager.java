package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {
    Map<String,Product> productList;
    Map<Integer,ProductType> productTypeList;
    public ProductManager(){
        productList = new HashMap<>();
        productTypeList = new HashMap<>();
    }

    public boolean addProduct(){
        System.out.println("***************************************");
        System.out.print("Add New Product\nProduct Code :");
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        sc.nextLine();

        if(productList.containsKey(code)){
            System.out.println("Product code already exists");
            return false;
        }

        //Insert details of product
        System.out.print("Name : ");
        String name = sc.nextLine();

        System.out.print("Weight : ");
        float weight = sc.nextFloat();

        System.out.print("Price : ");
        float price = sc.nextFloat();

        sc.nextLine();
        System.out.print("Details : ");
        String details = sc.nextLine();

        Product product = new Product(code);
        product.setName(name);
        product.setDetail(details);
        product.setPrice(price);
        product.setWeight(weight);

        System.out.println("***********************\nProduct Type Details");
        System.out.print("ID :");
        int typeId = sc.nextInt();
        if(productTypeList.containsKey(typeId)){
            product.setProductType(productTypeList.get(typeId));
        }
        else{
            sc.nextLine();
            System.out.print("Product type description :");
            String desc = sc.nextLine();
            ProductType productType = new ProductType(typeId,desc);
            productTypeList.put(typeId,productType);
            product.setProductType(productType);
        }

        productList.put(product.getProductCode(),product);
        return true;
    }

    public boolean save(Product product) {
        if(productList.containsKey(product.getProductCode())){
            productList.put(product.getProductCode(),product);
            return true;
        }
        return false;
    }

    // Delete a customer from customer table by its username
    public void remove(String productCode) {
        productList.remove(productCode);
    }
    public Product getProductInstance(String productCode){
        if(productList.containsKey(productCode)){
            return productList.get(productCode);
        }
        return null;
    }
    public boolean checkProductCode(String productCode){
        if(productList.containsKey(productCode)){
            return true;
        }
        return false;
    }
    public float checkOut(Map<String,Integer> cartList){
        System.out.println("**************************************************");
        System.out.println("Cart Checkout View\n");
        float totalCost =0;
        for(Map.Entry<String,Integer> entry : cartList.entrySet()){
            System.out.println("**************************************************");
            System.out.println("Product Code : "+entry.getKey());
            System.out.println("Product Name : "+productList.get(entry.getKey()).getName());
            System.out.println("Product Quantity : "+entry.getValue());
            totalCost += (productList.get(entry.getKey()).getPrice()*entry.getValue());
            System.out.println("Price : "+productList.get(entry.getKey()).getPrice()*entry.getValue());
            System.out.println("**************************************************");
        }
        System.out.println("Total Price = "+totalCost);
        return totalCost;
    }
    public void browseProduct(){
        for(Map.Entry<String,Product> entry : productList.entrySet()){
            System.out.println("**************************************************");
            System.out.println("Product Code : "+entry.getKey());
            System.out.println("Product Name : "+entry.getValue().getName());
            System.out.println("Product Weight : "+entry.getValue().getWeight());
            System.out.println("Product Details : "+entry.getValue().getDetail());
            System.out.println("Product Type Id : "+entry.getValue().getProductType().getId());
            System.out.println("Product Type Description : "+entry.getValue().getProductType().getDescription());
            System.out.println("Product Price : "+entry.getValue().getPrice());
            System.out.println("**************************************************");
        }
    }
}
