package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void lionHasManeIfMale() throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        Lion lion = new Lion(feline, "Самец");

        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionHasNoManeIfFemale() throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        Lion lion = new Lion(feline, "Самка");

        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void lionThrowsExceptionIfSexIsWrong() {
        Feline feline = Mockito.mock(Feline.class);

        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion(feline, "Неизвестно")
        );

        assertEquals(
                "Используйте допустимые значения пола животного - самей или самка",
                exception.getMessage()
        );
    }

    @Test
    public void getKittensUsesFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion(feline, "Самец");
        int actual = lion.getKittens();

        assertEquals(3, actual);
        verify(feline).getKittens();
    }

    @Test
    public void getFoodUsesFelinePredatorFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion(feline, "Самец");
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        verify(feline).getFood("Хищник");
    }
}
