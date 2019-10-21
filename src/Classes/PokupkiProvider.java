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

        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getCount() > 0) {
                System.out.printf("%d. Название шоколада: %s, вид шоколада: %s, цена: %d%n",
                        i + 1,
                        listProducts.get(i).getTitle(),
                        listProducts.get(i).getVid(),
                        listProducts.get(i).getPrice()
                );

            }

        }

        System.out.print("Выберите номер шоколада:");
        int takeProductNum = scanner.nextInt();
        Product product = listProducts.get(takeProductNum - 1);
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
        System.out.print("Выберите номер клиента:");
        int buyerNum = scanner.nextInt();
        Buyer buyer = listBuyers.get(buyerNum - 1);
        pokupki.setProduct(product);
        pokupki.setBuyer(buyer);
        pokupki.setTakeOn(new Date());
        return pokupki;
    }

    public void boughtBook(List<Pokupki> listPokupki) {

        System.out.println("Список проданых товаров");
        int i = 1;
        for (Pokupki pokupki : listPokupki) {
            if (pokupki.getTakeOn() != null
                    && pokupki.getProduct().getCount() < pokupki.getProduct().getQuantity()) {
                System.out.printf("%d. Покупатель %s %s купил товар %s%n",
                         i,
                         pokupki.getBuyer().getName(),
                         pokupki.getBuyer().getLastname(),
                         pokupki.getProduct().getTitle()
                );

            }
            i++;
        }

    }

}
