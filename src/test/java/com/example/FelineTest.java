package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> actual = feline.eatMeat();

        assertEquals(expected, actual);
    }

    @Test
    public void getFamilyReturnsCatsFamily() {
        Feline feline = new Feline();

        String actual = feline.getFamily();

        assertEquals("Кошачьи", actual);
    }

    @Test
    public void getKittensWithoutParamsReturnsOne() {
        Feline feline = new Feline();

        int actual = feline.getKittens();

        assertEquals(1, actual);
    }

    // Параметризованный тест
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 10})
    public void getKittensWithParamsReturnsSameValue(int kittensCount) {
        Feline feline = new Feline();

        int actual = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actual);
    }
}
