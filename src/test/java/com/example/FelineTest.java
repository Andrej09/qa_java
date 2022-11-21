package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {


    @Test
    public void getEatMeatTest() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(feline.getFood("Хищник"),feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи",feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        Assert.assertEquals(feline.getKittens(1),feline.getKittens());
    }

    @Mock
    Feline feline;

    @Test
    public void getReturnGetKittensTest() {
        feline.getKittens(1);
        Mockito.verify(feline).getKittens(1);
    }
}