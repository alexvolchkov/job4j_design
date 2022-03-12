package ru.job4j.ood.isp.menu;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertEquals(
                new Menu.MenuItemInfo(
                        "Сходить в магазин", List.of("Купить продукты"), STUB_ACTION, "1."
                ),
                menu.select("Сходить в магазин").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "Купить продукты", List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."
                ),
                menu.select("Купить продукты").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "Покормить собаку", List.of(), STUB_ACTION, "2."
                ),
                menu.select("Покормить собаку").get()
        );
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }

    @Test
    public void whenSelectItem() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        assertThat(menu.select("Купить продукты").get().getName(), is("Купить продукты"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotFindParent() {
        Menu menu = new SimpleMenu();
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
    }

    @Test
    public void whenMultiCallhasNextThenTrue() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
        assertThat(iterator.next(), is(menu.select("Сходить в магазин").get()));
        assertThat(iterator.next(), is(menu.select("Купить продукты").get()));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        Menu menu = new SimpleMenu();
        Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
        iterator.next();
    }

    @Test
    public void whenPrint() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        String ln = System.lineSeparator();
        MenuPrinter out = new StubMenuPrinter();
        out.print(menu);
        assertThat(out.toString(), is(
                "1. Сходить в магазин" + ln
                        + "\t1.1. Купить продукты" + ln
                        + "\t\t1.1.1. Купить хлеб" + ln
                        + "\t\t1.1.2. Купить молоко" + ln
                        + "2. Покормить собаку" + ln
        ));
    }
}