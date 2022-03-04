package ru.job4j.ood.lsp;

import org.junit.Test;


import java.time.LocalDate;
import java.time.Month;
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
                LocalDate.of(2022, Month.MARCH, 3),
                LocalDate.of(2022, Month.MARCH, 13),
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
                LocalDate.of(2022, Month.FEBRUARY, 20),
                LocalDate.of(2022, Month.MARCH, 10),
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
                LocalDate.of(2022, Month.FEBRUARY, 20),
                LocalDate.of(2022, Month.MARCH, 6),
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
                LocalDate.of(2022, Month.FEBRUARY, 20),
                LocalDate.of(2022, Month.MARCH, 3),
                50,
                0.20));
        new ControllQuality().distribution(foods, storages);
        assertThat(warehouse.find(el -> true).size(), is(0));
        assertThat(shop.find(el -> true).size(), is(0));
        assertThat(trash.find(el -> true).size(), is(1));
    }
}