package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class TODOApp {

    private final Output out;

    public TODOApp(Output out) {
        this.out = out;
    }

    private void showMenu(List<UserAction> actions) {
        out.println("===========");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    private void init(Input input, Menu menu, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select:");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, menu);
        }
    }

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
            Output output = new ConsoleOutput();
            MenuPrinter menuPrinter = new ConsoleMenuPrinter();
            Input input = new ValidateInput(output, new ConsoleInput());
            List<UserAction> actions = new ArrayList<>();
            actions.add(new ShowMenuAction(output, menuPrinter));
            actions.add(new CreateAction());
            actions.add(new ExitAction());
            new TODOApp(output).init(input, menu, actions);
    }
}
