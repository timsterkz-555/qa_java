package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LionParameterizedTest {

    @DisplayName("Определение наличия гривы по полу льва")
    @ParameterizedTest(name = "Пол: {0}, наличие гривы: {1}")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void testDoesHaveManeReturnsExpectedValue(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, mock(Feline.class));

        boolean actualHasMane = lion.doesHaveMane();

        assertEquals(expectedHasMane, actualHasMane, "Наличие гривы не соответствует полу льва");
    }
}
