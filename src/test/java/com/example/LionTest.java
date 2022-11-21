package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;


@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSex(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test()
    public void genderLionTest() throws Exception {
        Lion lion = new Lion(sex);
        Assert.assertEquals(hasMane,lion.doesHaveMane());
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensTest(){
        Feline feline = new Feline();
        Lion lion = new Lion(feline);
        Assert.assertEquals(feline.getKittens(),lion.getKittens());
    }

    @Test
    public void getFoodPredatorTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline);
        Assert.assertEquals(feline.getFood("Хищник"),lion.getFood());
    }
}