package ru.job4j.ood.isp.menu;

public class CreateAction implements UserAction {

    @Override
    public String name() {
        return "Создать задачу";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        String parentName = input.askStr("Введите имя родителя или null");
        if ("".equals(parentName) || "null".equalsIgnoreCase(parentName)) {
            parentName = Menu.ROOT;
        }
        String childName;
        do {
            childName = input.askStr("Введите имя задачи");
        } while (childName.isEmpty());
       return menu.add(parentName, childName, System.out::println);
    }
}
