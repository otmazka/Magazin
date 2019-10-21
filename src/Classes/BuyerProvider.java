/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import entity.Buyer;
import java.util.Scanner;

public class BuyerProvider {
     public Buyer createBuyer(){
        Scanner scanner = new Scanner(System.in);
        Buyer buyer = new Buyer();
        System.out.println("Имя покупателя: ");
        buyer.setName(scanner.nextLine());
        System.out.println("Фамилия читателя: ");
        buyer.setLastname(scanner.nextLine());
        System.out.println("Электронная почта: ");
        buyer.setEmail(scanner.nextLine());
        return buyer;
    }
}
