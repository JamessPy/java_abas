package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

    // Post requesti ele alma
    @PostMapping("/AbasPost")

    // insert işlemi
    String insert(@RequestBody Product product)
    {
        // Gelen verileri listede tutma
       product.Data.add(new Product(product.name,product.order_number,product.goods_no,product.amount,product.price));

        for (Product value : product.Data) {
        	String string = String.format(" Ürün adı: %s \n Sipariş numarası: %d \n Mal numarası: %d \n Ürün Miktarı: %d \n Ürün Fiyatı: %d", 
        			value.name, value.order_number,value.goods_no,value.amount,value.price);
        	System.out.println(string);

        }
        return "Veriler başarılı bir şekilde post edildi";
    }
    
    // Get işlemi
    @RequestMapping("/AbasGet")
    public String home(){
        return "Abas get örnegi";
    }
    
    // Response örnegi
    @GetMapping("/AbasResponse")
    public ResponseEntity<String> getName() {
        return ResponseEntity
                .status(HttpStatus.OK) // Başarılı mesajı
                .header("header", "ABAS")// Header kısmı
                .body("Response body"); // Body kısmı
    }
    
    

}