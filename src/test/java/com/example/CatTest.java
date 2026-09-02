package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CatTest {

    private Feline feline;
    private Cat cat;

    @BeforeEach
    void setUp() {
        feline = mock(Feline.class);
        cat = new Cat(feline);
    }

    @DisplayName("Получение звука кошки")
    @Test
    void testGetSoundReturnsMeow() {
        String actualSound = cat.getSound();

        assertEquals("Мяу", actualSound, "Звук кошки не соответствует ожидаемому");
    }

    @DisplayName("Получение рациона кошки")
    @Test
    void testGetFoodReturnsFoodFromFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood, "Рацион кошки не соответствует ожидаемому");
        verify(feline).eatMeat();
    }
}
