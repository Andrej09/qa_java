package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class LionSexDeterminationTest {
    private final String sex;
    private final boolean hasMane;

    public LionSexDeterminationTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, Имеет гриву: {1}")
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Mock
    Feline feline;

    @Test()
    public void genderLionTest() throws Exception {
        Lion lion = new Lion(sex,feline);
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }
}

