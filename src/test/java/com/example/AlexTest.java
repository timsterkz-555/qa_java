package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class AlexTest {

    private Alex alex;

    @BeforeEach
    void setUp() throws Exception {
        alex = new Alex(mock(Feline.class));
    }

    @DisplayName("Получение списка друзей Алекса")
    @Test
    void testGetFriendsReturnsAlexFriends() {
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");

        List<String> actualFriends = alex.getFriends();

        assertEquals(expectedFriends, actualFriends, "Список друзей Алекса не соответствует ожидаемому");
    }

    @DisplayName("Получение места жительства Алекса")
    @Test
    void testGetPlaceOfLivingReturnsNewYorkZoo() {
        String actualPlaceOfLiving = alex.getPlaceOfLiving();

        assertEquals("Нью-Йоркский зоопарк", actualPlaceOfLiving, "Место жительства Алекса не соответствует ожидаемому");
    }

    @DisplayName("У Алекса нет львят")
    @Test
    void testGetKittensReturnsZero() {
        int actualKittensCount = alex.getKittens();

        assertEquals(0, actualKittensCount, "Количество львят у Алекса не соответствует ожидаемому");
    }

    @DisplayName("Алекс является самцом")
    @Test
    void testDoesHaveManeReturnsTrue() {
        boolean actualHasMane = alex.doesHaveMane();

        assertTrue(actualHasMane, "У Алекса должна быть грива");
    }
}
