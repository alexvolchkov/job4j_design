package ru.job4j.ood.isp.example;

/*Необходимо разделить input и output. Может возникнуть ситуация когда input или output не понадобится */
public interface InputOutput {
    String input(String question);

    void print(Object obj);
}
