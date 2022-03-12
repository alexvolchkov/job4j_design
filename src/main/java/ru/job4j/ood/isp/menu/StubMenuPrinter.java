package ru.job4j.ood.isp.menu;

public class StubMenuPrinter implements MenuPrinter {
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo menuItemInfo : menu) {
            int count = menuItemInfo.getNumber().split("\\.").length - 1;
            buffer.append(String.format("%s%s %s",
                    "\t".repeat(count), menuItemInfo.getNumber(), menuItemInfo.getName()));
            buffer.append(System.lineSeparator());
        }
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
