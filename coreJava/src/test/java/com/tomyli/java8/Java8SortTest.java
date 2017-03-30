package com.tomyli.java8;

import com.google.common.collect.Lists;
import com.tomyli.entity.Human;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created by tomyli on 2017/3/30.
 */
public class Java8SortTest {

    @Test
    public void testSort_with_plain_java() throws Exception {

        ArrayList<Human> humans = Lists.newArrayList(new Human("tomy", 22), new Human("li", 25));

        Collections.sort(humans, new Comparator<Human>() {

            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });

        Assert.assertThat("li", equalTo(humans.get(0).getName()));
    }
}
