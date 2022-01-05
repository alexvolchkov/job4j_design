package ru.job4j.map;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + new SimpleDateFormat("dd.MM.yyyy").format(birthday.getTime())
                + '}';
    }

    public static void main(String[] args) {
        User user1 = new User("Alex", 2, new GregorianCalendar(1980, Calendar.AUGUST, 1));
        User user2 = new User("Alex", 2, new GregorianCalendar(1980, Calendar.AUGUST, 1));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object().hashCode());
        map.put(user2, new Object());
        for (User user : map.keySet()) {
            System.out.println(user + ": " + map.get(user));
        }
    }
}
