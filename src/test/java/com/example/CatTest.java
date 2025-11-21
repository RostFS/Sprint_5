package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    @Test
    public void getSoundReturnsMay() {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);

        String actual = cat.getSound();

        assertEquals("Мяу", actual);
    }

    @Test
    public void getFoodUsesFelineEatMeat() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(feline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(feline);
        List<String> actual = cat.getFood();

        assertEquals(expectedFood, actual);
        verify(feline).eatMeat();
    }
}
