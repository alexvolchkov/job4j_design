package ru.job4j.ood.lsp.example;

/* Ели в коде будет например список Rectangle и Square и затем в цикле будут изменяться длина и ширина
и вычисляется площадь, то для квадрата будет не верно посчитана площадь*/
public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

class Square extends Rectangle {
    public Square(int length) {
        super(length, length);
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(int width) {
        super.setLength(width);
        super.setWidth(width);
    }
}


