package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> mapPrevious = previous.stream().collect(Collectors.toMap(User::getId, User::getName));
        int added = 0;
        int changed = 0;
        for (User user : current) {
            if (!mapPrevious.containsKey(user.getId())) {
                added++;
            } else if (!Objects.equals(mapPrevious.remove(user.getId()), user.getName())) {
                changed++;
            }
        }
        int deleted = mapPrevious.size();
        return new Info(added, changed, deleted);
    }
}
