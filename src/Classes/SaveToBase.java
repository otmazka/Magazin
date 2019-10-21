package classes;

import entity.Buyer;
import entity.Pokupki;
import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveToBase {

    EntityManager em;
    EntityTransaction tx;

    public SaveToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKTVp18MagazinPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    public void saveProducts(List<Product> listProducts) {
        List<Product> listProductsSaved = loadProducts();

        for (int i = 0; i < listProducts.size(); i++) {
            if (listProductsSaved.contains(listProducts.get(i))
                    && !listProductsSaved.get(i).equals(listProducts.get(i))) {
                tx.begin();
                em.merge(listProducts.get(i));
                tx.commit();
            } else if (listProducts.get(i).getId() == null) {
                tx.begin();
                em.persist(listProducts.get(i));
                tx.commit();
            } else {
                continue;
            }
        }
    }

    public List<Product> loadProducts() {
        return em.createQuery("SELECT p FROM Book p")
                .getResultList();
    }

    public void saveBuyers(List<Buyer> listBuyers) {
        List<Buyer> listBuyersSaved = loadBuyers();

        for (int i = 0; i < listBuyers.size(); i++) {
            if (listBuyersSaved.contains(listBuyers.get(i))
                    && !listBuyersSaved.get(i).equals(listBuyers.get(i))) {
                tx.begin();
                em.merge(listBuyers.get(i));
                tx.commit();
            } else if (listBuyers.get(i).getId() == null) {
                tx.begin();
                em.persist(listBuyers.get(i));
                tx.commit();
            } else {
                continue;
            }
        }

    }

    public List<Buyer> loadBuyers() {
        return em.createQuery("SELECT b FROM Reader b")
                .getResultList();
    }

    void savePokupki(List<Pokupki> listPokupki) {
        for (Pokupki delPokupki : listPokupki) {
            int flag = 0;
            for (int i = 0; i < listPokupki.size(); i++) {
                if (delPokupki.getBuyer().equals(listPokupki.get(i).getBuyer())) {
                    if (delPokupki.getProduct().getId() == listPokupki.get(i).getProduct().getId()) {
                        flag++;
                    }
                    if (flag > 1) {
                        listPokupki.get(i).getProduct().setCount(listPokupki.get(i).getProduct().getCount() + 1);
                        listPokupki.remove(listPokupki.get(i));
                        System.out.println("Эту книгу читатель уже читал");
                        break;
                    }
                }
            }
            if (flag > 1) {
                break;
            }
        }
        List<Pokupki> listPokupkiSaved = loadPokupki();
        Pokupki newPokupki = null;
        Pokupki editPokupki = null;
       
        int i = 0;
        for (Pokupki p : listPokupki) {
            if (!listPokupkiSaved.contains(p) && p.getId() == null) {
                newPokupki = p;
                break;
            }
            if (listPokupkiSaved.contains(p) && !listPokupkiSaved.get(i).equals(p)) {
                editPokupki = p;
                break;
            }
            
            i++;
        }
        if (newPokupki != null) {
            tx.begin();
            em.persist(newPokupki);
            em.flush();
            em.merge(newPokupki.getProduct());
            tx.commit();
        }
        if (editPokupki != null) {
            tx.begin();
            em.merge(editPokupki);
            em.merge(editPokupki.getProduct());
            tx.commit();
        }
        
    }

    List<Pokupki> loadPokupki() {
        return em.createQuery("SELECT p FROM History p")
                .getResultList();
    }
}
