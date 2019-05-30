package br.kmyokoyama.cracking.chapter1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsUniqueTest {

    @ParameterizedTest(name = "{index} - All chars in \"{0}\" are unique: {1}")
    @MethodSource("provideStringsForChecker")
    @DisplayName("Check if string contains only unique chars")
    public void shouldReturnTrueOnlyWhenAllUniqueCharacters(String text, boolean expected) {
        // Given.
        IsUnique sut = new IsUnique();

        // When.
        boolean isUnique = sut.check(text);

        // Then.
        assertEquals(isUnique, expected);
    }

    private static Stream<Arguments> provideStringsForChecker() {
        return Stream.of(
                Arguments.of("abcd efgh", true),
                Arguments.of("abcd efah", false),
                Arguments.of("", true),
                Arguments.of("  ", false)
        );
    }
}
