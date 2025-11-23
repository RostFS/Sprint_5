package com.example;

import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class AnimalTest {

    @Test
    public void getFoodForHerbivoreReturnsCorrectList() throws Exception {
        Animal animal = new Animal();
        List<String> expected = Arrays.asList("Трава", "Различные растения");
        List<String> actual = animal.getFood("Травоядное");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFoodForPredatorReturnsCorrectList() throws Exception {
        Animal animal = new Animal();
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = animal.getFood("Хищник");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void getFoodThrowsExceptionForUnknownKind() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Всегдатое");
    }

    @Test
    public void getFamilyReturnsExpectedValue() {
        Animal animal = new Animal();
        Assert.assertEquals("Кошачьи", animal.getFamily());
    }
}
