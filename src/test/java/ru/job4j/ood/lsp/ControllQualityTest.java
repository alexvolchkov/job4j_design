package ru.job4j.ood.lsp;

import org.junit.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void whenAddWarehouse() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storeable> storages = List.of(warehouse, shop, trash);
        List<Food> foods = new ArrayList<>();
        foods.add(new Milk("milk",
                LocalDate.now().minusDays(2),
                LocalDate.now().plusDays(10),
                50,
                0.20));
        new ControllQuality().distribution(foods, storages);
        assertThat(warehouse.find(el -> true).size(), is(1));
        assertThat(shop.find(el -> true).size(), is(0));
        assertThat(trash.find(el -> true).size(), is(0));
    }

    @Test
    public void whenAddShopNotDiscount() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storeable> storages = List.of(warehouse, shop, trash);
        List<Food> foods = new ArrayList<>();
        foods.add(new Milk("milk",
                LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(5),
                50,
                0.20));
        new ControllQuality().distribution(foods, storages);
        assertThat(warehouse.find(el -> true).size(), is(0));
        assertThat(shop.find(el -> true).size(), is(1));
        assertThat(shop.find(el -> true).get(0).getPrice(), is(50.0));
        assertThat(trash.find(el -> true).size(), is(0));
    }

    @Test
    public void whenAddShopDiscount() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storeable> storages = List.of(warehouse, shop, trash);
        List<Food> foods = new ArrayList<>();
        foods.add(new Milk("milk",
                LocalDate.now().minusDays(7),
                LocalDate.now().plusDays(2),
                50,
                0.20));
        new ControllQuality().distribution(foods, storages);
        assertThat(warehouse.find(el -> true).size(), is(0));
        assertThat(shop.find(el -> true).size(), is(1));
        assertThat(shop.find(el -> true).get(0).getPrice(), is(40.0));
        assertThat(trash.find(el -> true).size(), is(0));
    }

    @Test
    public void whenAddTrash() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storeable> storages = List.of(warehouse, shop, trash);
        List<Food> foods = new ArrayList<>();
        foods.add(new Milk("milk",
                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(2),
                50,
                0.20));
        new ControllQuality().distribution(foods, storages);
        assertThat(warehouse.find(el -> true).size(), is(0));
        assertThat(shop.find(el -> true).size(), is(0));
        assertThat(trash.find(el -> true).size(), is(1));
    }

    @Test
    public void whenResortWarehouse() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storeable> storages = List.of(warehouse, shop, trash);
        List<Food> foods = new ArrayList<>();
        Food milk = new Milk("milk",
                LocalDate.now().minusDays(3),
                LocalDate.now().minusDays(1),
                50,
                0.20);
        trash.add(milk);
        milk.setExpiryDate(LocalDate.now().plusDays(10));
        new ControllQuality().resort(storages);
        assertThat(warehouse.find(el -> true).size(), is(1));
        assertThat(shop.find(el -> true).size(), is(0));
        assertThat(trash.find(el -> true).size(), is(0));
    }

    @Test
    public void whenResortShop() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storeable> storages = List.of(warehouse, shop, trash);
        List<Food> foods = new ArrayList<>();
        Food milk = new Milk("milk",
                LocalDate.now().minusDays(3),
                LocalDate.now().plusDays(20),
                50,
                0.20);
        warehouse.add(milk);
        milk.setExpiryDate(LocalDate.now().plusDays(1));
        new ControllQuality().resort(storages);
        assertThat(warehouse.find(el -> true).size(), is(0));
        assertThat(shop.find(el -> true).size(), is(1));
        assertThat(trash.find(el -> true).size(), is(0));
    }

    @Test
    public void whenResortTrash() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storeable> storages = List.of(warehouse, shop, trash);
        List<Food> foods = new ArrayList<>();
        Food milk = new Milk("milk",
                LocalDate.now().minusDays(3),
                LocalDate.now().plusDays(20),
                50,
                0.20);
        warehouse.add(milk);
        milk.setExpiryDate(LocalDate.now().minusDays(1));
        new ControllQuality().resort(storages);
        assertThat(warehouse.find(el -> true).size(), is(0));
        assertThat(shop.find(el -> true).size(), is(0));
        assertThat(trash.find(el -> true).size(), is(1));
    }
}