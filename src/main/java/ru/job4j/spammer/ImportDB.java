package ru.job4j.spammer;

import ru.job4j.jdbc.TableEditor;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .map(el -> el.split(";"))
                    .forEach(el -> users.add(new User(el[0], el[1])));
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users (name, email) "
                                                                    + "values (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileReader fr = new FileReader("./app.properties")) {
            cfg.load(fr);
        }
        TableEditor tableEditor = new TableEditor(cfg);
        tableEditor.createTable("users");
        tableEditor.addColumn("users", "id", "serial primary key");
        tableEditor.addColumn("users", "name", "text");
        tableEditor.addColumn("users", "email", "text");
        ImportDB db = new ImportDB(cfg, "./dump.txt");
        db.save(db.load());
    }

}
