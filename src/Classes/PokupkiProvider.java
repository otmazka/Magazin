
package Classes;

import entity.Buyer;
import entity.Pokupki;
import entity.Product;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class PokupkiProvider {

    Scanner scanner = new Scanner(System.in);

    public Pokupki createPokupki(List<Product> listProducts, List<Buyer> listBuyers) {

        Pokupki pokupki = new Pokupki();

        System.out.println("Список продуктов: ");
        int countCurrentProduct = 0;
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getCount() > 0) {
                System.out.printf("%d. Название шоколада: %s, вид шоколада: %s, цена: %d%n",
                         i + 1,
                         listProducts.get(i).getTitle(),
                         listProducts.get(i).getVid(),
                         listProducts.get(i).getPrice()
                );
                countCurrentProduct++;
            }

        }
        if (countCurrentProduct == 0) {
            System.out.println("Нет в наличии.");
            return null;
        }
        System.out.print("Выберите номер шоколада:");
        int takeBookNum = scanner.nextInt();
        Product product = listProducts.get(takeBookNum - 1);
        if (product.getCount() > 0) {
            product.setCount(product.getCount() - 1);
            System.out.println("Список покупателей: ");
            int i = 0;
            for (Buyer b : listBuyers) {
                System.out.printf("%d. Имя и фамилия покупателя: %s %s, email: %s%n",
                         i + 1,
                         b.getName(),
                         b.getLastname(),
                         b.getEmail()
                );
                i++;
            }
            System.out.print("Выберите номер покупателя:");
            int readerNum = scanner.nextInt();
            Buyer buyer = listBuyers.get(readerNum - 1);
            pokupki.setProduct(product);
            pokupki.setBuyer(buyer);
            pokupki.setTakeOn(new Date());
            return pokupki;
        } else {
            System.out.println("Продукты \""
                    + product.getTitle()
                    + "\" уже все проданы."
            );
            return null;
        }

    }

}
