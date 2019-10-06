/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import entity.Product;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ProductProvider {
   public Product createProduct(){
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        System.out.println("Название шоколада: ");
        product.setTitle(scanner.nextLine());
        System.out.println("Вид шоколада: ");
        product.setVid(scanner.nextLine());
        System.out.println("Цена шоколада: ");
        product.setPrice(new Integer(scanner.nextLine()));
        System.out.println("Количество штук: ");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));
        return product;
    } 
}
