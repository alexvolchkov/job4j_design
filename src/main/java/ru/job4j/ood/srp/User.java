package ru.job4j.ood.srp;
/* Совмещение модели и загрузки в БД и выгрузки из БД */
public class User {

    private int id;
    private String name;

    public void save(User user) {
        /* Сохранение в базу данных */
    }

    public User load(int id) {
        /* Загрузка из базы данных */
        return null;
    }

}
