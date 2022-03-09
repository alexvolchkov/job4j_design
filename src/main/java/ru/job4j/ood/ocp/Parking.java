package ru.job4j.ood.ocp;

import java.util.ArrayList;

/*Если нужно будет передавать не Car, а например Truck или возвращать не ArrayList, а HashSet то
 * придется переписывать метод.  */

public class Parking {

    public ArrayList<Car> find(Car car) {
        return new ArrayList<>();
    }
}
