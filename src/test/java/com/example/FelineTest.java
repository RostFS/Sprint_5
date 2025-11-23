package com.example;

import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class FelineTest {

    // 1. getFamily() возвращает "Кошачьи"
    @Test
    public void getFamilyReturnsFelineFamily() {
        Feline feline = new Feline();

        String expected = "Кошачьи";
        String actual = feline.getFamily();

        Assert.assertEquals(expected, actual);
    }

    // 2. eatMeat() делегирует в getFood("Хищник")
    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {
        Feline feline = new Feline();

        List<String> expected = feline.getFood("Хищник");
        List<String> actual = feline.eatMeat();

        Assert.assertEquals(expected, actual);
    }

    // 3. getKittens() без аргументов возвращает 1
    @Test
    public void getKittensWithoutArgsReturnsOne() {
        Feline feline = new Feline();

        int expected = 1;
        int actual = feline.getKittens();

        Assert.assertEquals(expected, actual);
    }

    // 4. getKittens(int) возвращает переданное значение
    @Test
    public void getKittensWithArgReturnsPassedValue() {
        Feline feline = new Feline();

        int expected = 5;
        int actual = feline.getKittens(5);

        Assert.assertEquals(expected, actual);
    }
}
