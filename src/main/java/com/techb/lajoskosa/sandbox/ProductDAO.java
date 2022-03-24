package com.techb.lajoskosa.sandbox;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductDAO {
    List<Product> shoppingCart = new ArrayList<>();

    public ProductDAO() {
        this.addProduct(new Product("Samsung TV",     429.99,1));
        this.addProduct(new Product("HAL 9000",       34.99, 1));
        this.addProduct(new Product("LG Soundsphere", 129.99,1));
        this.addProduct(new Product("HDMI Cable 3ft", 13.49, 3));

    }
//      TASK: Adding Product to cart
    public void addProduct(Product product){
        shoppingCart.add(product);

    }


//      TASK: Showing All Products in the cart
    public void consoleAllProducts(){
        Double total = 0d;
        System.out.println(     "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\n" +
                                "█ SHOPPING CART v1.3.7 █\n" +
                                "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");

        for (Product product : shoppingCart){
            System.out.printf(  "▐ Name:  %s\n" +
                                "▐ Price: $%.2f  \n" +
                                "█▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂█\n",product.getProductName(),product.getProductPrice());
            total =+ product.getProductPrice();

        }
        System.out.printf(      "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\n" +
                                "▌ TOTAL: $%.2f\n" +
                                "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n\n\n\n",total);
    }

    public String getCartASCII(){
        StringBuilder sb = new StringBuilder();

        Double total = 0d;
            sb.append(  "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█<br/>" +
                        "█ SHOPPING CART v1.3.7 █<br/>" +
                        "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█<br/>");

        for (Product product : shoppingCart){
            sb.append(String.format("▐ Name:  %s<br/>" +
                                    "▐ Price: $%.2f<br/>" +
                                    "▐ Count: %d<br/>" +
                                    "▐ Subtotal: $%.2f<br/>" +
                                    "█▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂<br/>",
                    product.getProductName(),
                    product.getProductPrice(),
                    product.getItemCount(),
                    product.getSubTotal()
                    )
            );
            total += product.getProductPrice();

        }
            sb.append(String.format("█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█<br/>" +
                                    "▌ TOTAL: $%.2f<br/>" +
                                    "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█<br/><br/><br/><br/>",total));

        String preTag = String.format("<pre><span class=\"inner-pre\" style=\"font-size: 18px\">%s</span></pre>",sb);
        return preTag;

    }

//      TASK: Showing All Products in the cart
    public List<Product> getCartList(){
        return shoppingCart;
    }

    public Double cartTotal(){
        Double total = 0d;
        for(Product product : shoppingCart){
            total += (product.getProductPrice() * product.getItemCount());
        }
        return total;
    }

//     TASK: Updating Product to cart based on product description
    public void updateProduct(int index, String newName, Double newPrice, int newAmount){
        shoppingCart.get(index).setProductName(newName);
        shoppingCart.get(index).setProductPrice(newPrice);
        shoppingCart.get(index).setItemCount(newAmount);
    }
//     TASK: Updating Product to cart based on product description
    public void updateAmount(int index, int newAmount){
        shoppingCart.get(index).setItemCount(newAmount);
    }
//      TASK: Delete a product from cart based on product description
    public void deleteCartItem(int index){
        shoppingCart.remove(index);
    }
    //      TASK: Delete a product from cart based on product description
    public void emptyCart(){
        shoppingCart.clear();
    }
    public Product getCartItem(int index){
        return shoppingCart.get(index);
    }

//  TASK: Return method to print the number of items in cart + Return Total Amount of the cart
    public String itemsInCart(){
        int products = getNumProducts();
        int count    = getTotalItemCount();
        Double total = cartTotal();


        return String.format(   "<pre><span class=\"inner-pre\" style=\"font-size: 18px\">Products in cart: %d\n" +
                                "Total item count: %d\n" +
                                "Total Cost:       $%.2f\n</span></pre>",products,count,total);
    }
//      HELPER METHODS
    public int getNumProducts(){
        return shoppingCart.size();
    }

    public int getTotalItemCount(){
        int count =0;
        for(Product product: shoppingCart){
            count += product.getItemCount();
        }
        return count;
    }

    public int getCountProducts(){
        int items = 0;
        for(Product product : shoppingCart){
            items =+ product.getItemCount();
        }
        return items;
    }
}