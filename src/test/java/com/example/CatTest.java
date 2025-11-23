package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CatTest {

    // 1. getSound() возвращает "Мяу"
    @Test
    public void getSoundReturnsMeow() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);

        String expected = "Мяу";
        String actual = cat.getSound();

        Assert.assertEquals(expected, actual);
    }

    // 2. getFood() делегирует в Feline.eatMeat()
    @Test
    public void getFoodReturnsFelineEatMeat() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);

        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = cat.getFood();

        Assert.assertEquals(expected, actual);
    }
}
