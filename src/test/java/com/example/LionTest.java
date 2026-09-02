package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LionTest {

    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = mock(Feline.class);
    }

    @DisplayName("Ошибка при создании льва с неизвестным полом")
    @Test
    void testCreateLionWithInvalidSexThrowsException() {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("Неизвестный пол", feline),
                "При неизвестном поле льва должна возникнуть ошибка");

        assertTrue(
                exception.getMessage().contains("Используйте допустимые значения пола животного"),
                "Текст ошибки не соответствует ожидаемому");
    }

    @DisplayName("Получение количества котят у льва")
    @Test
    void testGetKittensReturnsKittensCountFromFeline() throws Exception {
        int expectedKittensCount = 2;
        when(feline.getKittens()).thenReturn(expectedKittensCount);
        Lion lion = new Lion("Самец", feline);

        int actualKittensCount = lion.getKittens();

        assertEquals(expectedKittensCount, actualKittensCount, "Количество котят у льва не соответствует ожидаемому");
        verify(feline).getKittens();
    }

    @DisplayName("Получение рациона льва")
    @Test
    void testGetFoodReturnsFoodFromFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood, "Рацион льва не соответствует ожидаемому");
        verify(feline).getFood("Хищник");
    }
}
