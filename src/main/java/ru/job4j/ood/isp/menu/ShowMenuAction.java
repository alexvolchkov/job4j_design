package ru.job4j.ood.isp.menu;

import java.util.Optional;

public class ShowMenuAction implements UserAction {
    private final Output out;
    private final MenuPrinter menuPrinter;

    public ShowMenuAction(Output out, MenuPrinter menuPrinter) {
        this.out = out;
        this.menuPrinter = menuPrinter;
    }

    @Override
    public String name() {
        return "Вывести список задач";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        out.println("=== Список задач ===");
        menuPrinter.print(menu);
        String select = input.askStr("Введите имя задачи или нажмите Enter для возврата в предыдущее меню");
        if (!select.isEmpty()) {
            Optional<Menu.MenuItemInfo> menuItemInfo = menu.select(select);
            if (menuItemInfo.isPresent()) {
                menuItemInfo.get().getActionDelegate().delegate();
            } else {
                out.println("Не верно введено имя задачи");
            }
        }
        return true;
    }
}
