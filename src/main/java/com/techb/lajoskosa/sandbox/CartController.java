package com.techb.lajoskosa.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ProductDAO cart = new ProductDAO();

    @GetMapping("/AllConsole")
    public void printCartToConsole(){
        cart.consoleAllProducts();
    }
//      TASK: Showing All Products in the cart
    @GetMapping("/All")
    public List<Product> getCartList(){
        return cart.getCartList();
    }
    @GetMapping("/total")
    public String getTotalPrice(){
        return  String.format("Total: $%s",cart.cartTotal());
    }

    @GetMapping("/item-count")
    public String getItemCount(){
        return  String.format("<h1 style=\"font-size: 36px\">Cart details:</h1> %s",cart.itemsInCart());
    }


    @GetMapping("/AllASCII")
    public String getCartASCII(){
        return cart.getCartASCII();
    }


//      TASK:
//      TASK: Adding Product to cart
    @PostMapping("/addProduct")
    public String addToCart(@RequestBody Product product){
        cart.addProduct(product);
        return String.format("Product Added Successfully - %s",product.getProductName());
    }

    @PostMapping("/delete/item/")
    public String deleteItem(@RequestBody Product product, int id){
        String deleted = cart.getCartItem(id).getProductName();
        cart.deleteCartItem(id);
        return String.format("Product Deleted Successfully - %s",deleted);
    }

    @PostMapping("/delete/all")
    public String demptyCart(@RequestBody Product product){
        cart.emptyCart();
        return cart.getCartASCII();
    }




////      TASK: Updating Product to cart based on product description
//    @PostMapping("/update-product/{index}")
//    public String updateProduct(@RequestBody Product product, int index){
//        List<Product> productList = cart.getCartList();
//        String oldName   = productList.get(index).getProductName();
//        Double oldPrice  = productList.get(index).getProductPrice();
//        int    oldAmount = productList.get(index).getItemCount();
//        cart.updateProduct(index,"New Name",3.50,3);
//        String newName   = productList.get(index).getProductName();
//        Double newPrice  = productList.get(index).getProductPrice();
//        int    newAmount = productList.get(index).getItemCount();
//
//        return String.format(   "<pre>Product updated:\n" +
//                                "Name:  %s ->%s\n" +
//                                "Price: %.2f -> %.2f\n" +
//                                "Count: %d ->%d\n----------\n</pre>",oldName,newName,oldPrice,newPrice,oldAmount,newAmount);
//    }

    @PostMapping("/update-product/{index}")
    public String updateProductCount(@RequestBody Product product, @PathVariable int index){
        List<Product> productList = cart.getCartList();
        int    oldAmount = productList.get(index).getItemCount();
        cart.updateAmount(index,2);
        int    newAmount = productList.get(index).getItemCount();
        return String.format("<pre>Desired count changed: %d -> %d</pre>",oldAmount,newAmount);
    }



}
