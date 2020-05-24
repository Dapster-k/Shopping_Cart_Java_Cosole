package Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<String,Integer> cartList;
    public Cart(){
        cartList = new HashMap<>();
    }
    void addToCart(String productCode,int quantity){
        if(cartList.containsKey(productCode))
            quantity += cartList.get(productCode);
        cartList.put(productCode,quantity);
    }
    public Map<String,Integer> getCartList(){
        return cartList;
    }
    public void clearCartList(){
        cartList.clear();
    }
}
