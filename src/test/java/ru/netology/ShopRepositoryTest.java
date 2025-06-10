package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    Product prod1 = new Product(1, "Book", 750);
    Product prod2 = new Product(2, "Pencil", 50);
    Product prod3 = new Product(3, "copybook", 200);

    @Test
    public void deletingNotExistentOne() {
        ShopRepository repo = new ShopRepository();

        repo.add(prod1);
        repo.add(prod2);
        repo.add(prod3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4));
    }

    @Test
    public void deletingExistingOne() {
        ShopRepository repo = new ShopRepository();

        repo.add(prod1);
        repo.add(prod2);
        repo.add(prod3);
        repo.remove(3);

        Product[] expected = {prod1, prod2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addingExistingOne() {
        ShopRepository repo = new ShopRepository();

        repo.add(prod1);
        repo.add(prod2);
        repo.add(prod3);

        Assertions.assertThrows(AlreadyExistsException.class,
                () -> repo.add(3));
    }

    @Test
    public void addingNotExistingOne() {
        ShopRepository repo = new ShopRepository();

        repo.add(prod1);
        repo.add(prod2);
        repo.add(prod3);

        Product[] expected = {prod1, prod2, prod3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}