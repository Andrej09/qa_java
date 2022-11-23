package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

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
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class LionTest {
        @Mock
        Feline feline;

        @Before
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void getKittensTest() throws Exception {
            Lion lion = new Lion("Самка", feline);
            Mockito.when(feline.getKittens()).thenReturn(1);
            Assert.assertEquals(feline.getKittens(), lion.getKittens());
        }

        @Test
        public void getFoodTest() throws Exception {
            Lion lion = new Lion("Самец", feline);
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        }
    }

}

