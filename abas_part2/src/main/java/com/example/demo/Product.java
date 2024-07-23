package com.example.demo;

import java.util.ArrayList;

public class Product {

    // Arraylist
    static ArrayList<Product> Data = new ArrayList<Product>();
    
    // Post edeceğimiz parametreler
    String name;
    int order_number;
    int goods_no;
    int amount;
    int price;
    Product(String name,int order_number,int goods_no, int amount, int price)
    {
    	this.name = name;
    	this.order_number = order_number;
    	this.goods_no = goods_no;
    	this.amount = amount;
    	this.price = price;
    }
}