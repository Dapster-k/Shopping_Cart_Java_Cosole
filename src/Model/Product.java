package Model;

import java.util.Map;

public class Product {
    private String      productCode;
    private String      name;
    private float       weight;
    private float       price;
    private String      detail;
    private Register    register;
    private ProductType productType;

    //constructor
    public Product(String code) {
        this.productCode = code;
        this.register = new Register();
    }

    // GET and SET methods
    public String getProductCode() {
        return productCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }


}
