package com.example;

import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class LionTest {

    // 1. Самец льва -> грива есть
    @Test
    public void maleLionHasMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самец");

        Assert.assertTrue(lion.doesHaveMane());
    }

    // 2. Самка льва -> гривы нет
    @Test
    public void femaleLionHasNoMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самка");

        Assert.assertFalse(lion.doesHaveMane());
    }

    // 3. Неверный пол -> выбрасывается Exception (ветка else в конструкторе)
    @Test(expected = Exception.class)
    public void invalidSexThrowsException() throws Exception {
        Feline feline = new Feline();

        // любое значение, не "Самец" и не "Самка"
        new Lion(feline, "Неизвестно");
    }

    // 4. getKittens() делегирует в Feline.getKittens()
    @Test
    public void getKittensDelegatesToFeline() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самец");

        int expected = 1;  // Feline.getKittens() по умолчанию возвращает 1
        int actual = lion.getKittens();

        Assert.assertEquals(expected, actual);
    }

    // 5. getFood() использует Feline.eatMeat()
    @Test
    public void getFoodUsesFelineEatMeat() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самец");

        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();

        Assert.assertEquals(expected, actual);
    }
}
