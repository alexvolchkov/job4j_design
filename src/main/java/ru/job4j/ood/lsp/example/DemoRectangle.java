package ru.job4j.ood.lsp.example;

/* Нельзя использовать getClass(), instance of  */
public class DemoRectangle {

    public void add(Rectangle rectangle) {
        if (rectangle.getClass() == Square.class) {
            System.out.println();
            /* Какой то код*/
        }
    }
}
