package ru.job4j.ood.isp.menu;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Выход";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        return false;
    }
}
