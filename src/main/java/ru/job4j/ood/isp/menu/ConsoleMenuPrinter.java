package ru.job4j.ood.isp.menu;

public class ConsoleMenuPrinter implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        if (menu.iterator().hasNext()) {
            for (Menu.MenuItemInfo menuItemInfo : menu) {
                int count = menuItemInfo.getNumber().split("\\.").length - 1;
                System.out.println(String.format("%s%s %s", "\t".repeat(count),
                        menuItemInfo.getNumber(), menuItemInfo.getName()));
            }
        } else {
            System.out.println("Еще нет задач");
        }
    }
}
