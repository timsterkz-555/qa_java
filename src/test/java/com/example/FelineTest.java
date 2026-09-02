package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineTest {

    private final Feline feline = new Feline();

    @DisplayName("Получение рациона хищника")
    @Test
    void testEatMeatReturnsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood, "Рацион хищника не соответствует ожидаемому");
    }

    @DisplayName("Получение названия семейства кошачьих")
    @Test
    void testGetFamilyReturnsFelineFamily() {
        String actualFamily = feline.getFamily();

        assertEquals("Кошачьи", actualFamily, "Название семейства не соответствует ожидаемому");
    }

    @DisplayName("Получение количества котят по умолчанию")
    @Test
    void testGetKittensReturnsOneKitten() {
        int actualKittensCount = feline.getKittens();

        assertEquals(1, actualKittensCount, "Количество котят по умолчанию не соответствует ожидаемому");
    }

    @DisplayName("Получение заданного количества котят")
    @Test
    void testGetKittensWithSpecifiedCountReturnsSpecifiedCount() {
        int expectedKittensCount = 3;

        int actualKittensCount = feline.getKittens(expectedKittensCount);

        assertEquals(expectedKittensCount, actualKittensCount, "Количество котят не соответствует заданному");
    }
}
