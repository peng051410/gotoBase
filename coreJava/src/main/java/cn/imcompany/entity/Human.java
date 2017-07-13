package cn.imcompany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tomyli on 2017/3/30.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {

    private String name;
    private int age;

    public static int compareByNameThenAge(Human h1, Human h2) {

        if (h1.getName().equals(h2.getName())) {
            return Integer.compare(h1.getAge(), h2.getAge());
        }
        return h1.getName().compareTo(h2.getName());
    }
}
