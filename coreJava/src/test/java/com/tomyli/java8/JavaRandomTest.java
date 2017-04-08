package com.tomyli.java8;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

/**
 * 生成随机数的测试，主要包括常用的long,float,double,int的随机数的生成
 * <p>
 * Created by tomyli on 2017/4/6.
 */
public class JavaRandomTest {

    @Test
    public void testRandom_generatingLongUnbounded() throws Exception {

        long unboundedLong = new Random().nextLong();
        System.out.println(unboundedLong);
    }

    @Test
    public void testRandom_generatingLongBounded_withRange() throws Exception {

        long min = 1;
        long max = 10;
        long rangeLong = min + (((long) (new Random().nextDouble() * (max - min))));
        System.out.println(rangeLong);
    }

    @Test
    public void testRandom_generatingLongBounded_withApacheMath() throws Exception {

        long min = 1;
        long max = 10;
        long rangeLong = new RandomDataGenerator().nextLong(min, max);
        System.out.println(rangeLong);
    }

    @Test
    public void testRandom_generatingIntegerUnbounded() throws Exception {

        int intUnbounded = new Random().nextInt();
        System.out.println(intUnbounded);
    }

    @Test
    public void testRandom_generatingIntegerBounded_withRange() throws Exception {

        int min = 1;
        int max = 10;
        int intBounded = min + ((int) (new Random().nextFloat() * (max - min)));
        System.out.println(intBounded);
    }

    @Test
    public void testRandom_generatingIntegerBounded_withApacheMath() throws Exception {

        int min = 1;
        int max = 10;
        int intBounded = new RandomDataGenerator().nextInt(min, max);
        System.out.println(intBounded);
    }

    @Test
    public void testRandom_generatingIntegerBounded_withApacheLangInclusive() throws Exception {

        int min = 1;
        int max = 10;
        int intBounded = RandomUtils.nextInt(min, max);
        System.out.println(intBounded);
    }

    @Test
    public void testRandom_generatingFloat0To1() throws Exception {

        float floatUnbounded = new Random().nextFloat();
        System.out.println(floatUnbounded);
    }

    @Test
    public void testRandom_generatingFloatBounded_withRange() throws Exception {

        float min = 1f;
        float max = 10f;
        float floatBounded = min + new Random().nextFloat() * (max - min);
        System.out.println(floatBounded);
    }

    @Test
    public void testRandom_generatingFloatBounded_withApacheMath() throws Exception {

        float min = 1f;
        float max = 10f;
        float randomFloat = new RandomDataGenerator().getRandomGenerator().nextFloat();
        float generatedFloat = min + randomFloat * (max - min);
        System.out.println(generatedFloat);
    }

    @Test
    public void testRandom_generatingDouble0To1() throws Exception {

        double generatorDouble = new Random().nextDouble();
        System.out.println(generatorDouble);
    }

    @Test
    public void testRandom_generatingDoubleBounded_withRange() throws Exception {

        double min = 1.0;
        double max = 10.0;
        double boundedDouble = min + new Random().nextDouble() * (max - min);
        System.out.println(boundedDouble);
        assertThat(boundedDouble, greaterThan(min));
        assertThat(boundedDouble, lessThan(max));
    }


    @Test
    public void testRandom_generatingDoubleBounded_withApacheMath() throws Exception {

        double min = 1.0;
        double max = 10.0;
        double boundedDouble = new RandomDataGenerator().getRandomGenerator().nextDouble();
        double generatorDouble = min + boundedDouble * (max - min);
        System.out.println(generatorDouble);
        assertThat(generatorDouble, greaterThan(min));
        assertThat(generatorDouble, lessThan(max));
    }

}
