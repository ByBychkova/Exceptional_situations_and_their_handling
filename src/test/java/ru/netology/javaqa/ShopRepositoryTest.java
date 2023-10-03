package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Сон в летнюю ночь", 1000);
    Product product2 = new Product(2, "Война и мир", 2000);
    Product product3 = new Product(3, "Сказка о царе Султане", 1500);


    @Test
    public void shouldAddProductInRepository() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deletingAnExistingElement() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(1);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void generatingANotFoundException() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }
}