package com.example.coffeeshoffee.Models;

public class CartModels {
    int cartimage;
    String cartname, cartprice, cartorderNumber;

    public CartModels(int cartimage, String cartname, String cartprice, String cartorderNumber) {
        this.cartimage = cartimage;
        this.cartname = cartname;
        this.cartprice = cartprice;
        this.cartorderNumber = cartorderNumber;
    }

    public CartModels() {

    }

    public int getCartimage() {
        return cartimage;
    }

    public void setCartimage(int cartimage) {
        this.cartimage = cartimage;
    }

    public String getCartname() {
        return cartname;
    }

    public void setCartname(String cartname) {
        this.cartname = cartname;
    }

    public String getCartprice() {
        return cartprice;
    }

    public void setCartprice(String cartprice) {
        this.cartprice = cartprice;
    }

    public String getCartorderNumber() {
        return cartorderNumber;
    }

    public void setCartorderNumber(String cartorderNumber) {
        this.cartorderNumber = cartorderNumber;
    }
}

