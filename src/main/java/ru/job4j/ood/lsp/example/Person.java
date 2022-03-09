package ru.job4j.ood.lsp.example;

/* Предусловия не могут быть усилены в подклассе*/
public class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}

class User extends Person {
    @Override
    public void setName(String name) {
        if (name != null && name.length() > 1) {
            super.setName(name);
        }
    }
}
