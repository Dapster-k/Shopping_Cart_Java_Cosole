package Model;

import java.time.LocalDate;
import java.util.Date;

public class User extends Person {
    // User attributes
    private String      name;
    private String      telephone;
    private LocalDate birthday;
    private Address     actualAddress;
    private Register    register;
    private Cart        cart;

    public User(String username,String password){
        super(username,password);
        this.actualAddress = new Address();
        this.register = new Register();
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Address getActualAddress() {
        return actualAddress;
    }

    public void setActualAddress(Address actualAddress) {
        this.actualAddress = actualAddress;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
    public void addItemToCart(String productCode,int quantity){
        cart.addToCart(productCode,quantity);
    }
    public Cart getCart(){
        return cart;
    }
    public void clearCart(){
        cart.clearCartList();
    }
}
