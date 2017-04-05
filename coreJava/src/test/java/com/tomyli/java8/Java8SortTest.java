package com.tomyli.java8;

import com.google.common.collect.Lists;
import com.tomyli.entity.Human;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by tomyli on 2017/3/30.
 */
public class Java8SortTest {

    @Test
    public void testSortByName_with_plain_java() throws Exception {

        ArrayList<Human> humans = Lists.newArrayList(
                new Human("tomy", 22),
                new Human("li", 25)
        );

        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });

        Assert.assertThat(humans.get(0), equalTo(new Human("li", 25)));
    }

    @Test
    public void testSortByName_with_lambda() throws Exception {

        ArrayList<Human> humans = Lists.newArrayList(
                new Human("tomy", 22),
                new Human("li", 25)
        );
        humans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));

        Assert.assertThat("tomy", equalTo(humans.get(1).getName()));

    }

    @Test
    public void testSortByNameSimplify_with_lambda() throws Exception {

        ArrayList<Human> humans = Lists.newArrayList(
                new Human("tomy", 22),
                new Human("li", 25)
        );
        humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));

        Assert.assertThat("tomy", equalTo(humans.get(1).getName()));

    }

    @Test
    public void testSortByName_with_lambda_form() throws Exception {

        ArrayList<Human> humans = Lists.newArrayList(new Human("tomy", 22), new Human("li", 25));
        humans.sort(Comparator.comparing(Human::getName));
    }

    @Test
    public void testSort_with_givenMethodDefinition() throws Exception {

        ArrayList<Human> humans = Lists.newArrayList(
                new Human("tomy", 22),
                new Human("li", 25)
        );
        humans.sort(Human::compareByNameThenAge);
        Assert.assertThat("tomy", is(equalTo(humans.get(1).getName())));
    }

    @Test
    public void testSort_with_givenInstanceMethod() throws Exception {

        ArrayList<Human> humans = Lists.newArrayList(
                new Human("tomy", 22),
                new Human("li", 25)
        );

        Collections.sort(humans, Comparator.comparing(Human::getName));
        Assert.assertThat("tomy", equalTo(humans.get(1).getName()));
    }

    @Test
    public void testSort_with_comparatorReverse() throws Exception {

        ArrayList<Human> humans = Lists.newArrayList(
                new Human("tomy", 22),
                new Human("li", 25)
        );

        Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
        humans.sort(comparator.reversed());
        Assert.assertThat("tomy", equalTo(humans.get(0).getName()));

    }

    @Test
    public void testSort_with_multipleComparator() throws Exception {

        ArrayList<Human> humans = Lists.newArrayList(
                new Human("tomy", 22),
                new Human("li", 25)
        );

        Comparator<Human> comparator = (h1, h2) -> {

            if (h1.getName().equals(h2.getName())) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
            return h1.getName().compareTo(h2.getName());
        };
        humans.sort(comparator.reversed());
        Assert.assertThat("tomy", equalTo(humans.get(0).getName()));

    }

    @Test
    public void testSort_with_multipleComparator_composition() throws Exception {

        ArrayList<Human> humans = Lists.newArrayList(
                new Human("tomy", 22),
                new Human("tomy", 25)
        );

        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        Assert.assertThat(humans.get(0), equalTo(new Human("tomy", 22)));

    }
}
