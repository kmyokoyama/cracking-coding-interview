package br.kmyokoyama.cracking.chapter1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckPermutationTest {

    @ParameterizedTest(name = "{index} - String \"{0}\" is a permutation of \"{1}\": {2}")
    @MethodSource("provideStringsForCheckPermutation")
    @DisplayName("Check if one string is a permutation of another")
    public void shoudlReturnTrueIfStringsArePermutation(String str1, String str2, boolean expected) {
        // Given.
        CheckPermutation sut = new CheckPermutation();

        // When.
        boolean isPermutation = sut.check(str1, str2);

        // Then.
        assertEquals(expected, isPermutation);
    }

    private static Stream<Arguments> provideStringsForCheckPermutation() {
        return Stream.of(
                Arguments.of("abc def", "fbae cd", true),
                Arguments.of("abc def", "fbaecd ", true),
                Arguments.of("", "", true),
                Arguments.of("abc def", "fbaecd", false),
                Arguments.of(" ", "", false)
        );
    }
}
