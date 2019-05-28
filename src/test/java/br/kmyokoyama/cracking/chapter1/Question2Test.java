package br.kmyokoyama.cracking.chapter1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Question2Test {

    @ParameterizedTest(name = "{index} - Inverted \"{0}\" is \"{1}\"")
    @MethodSource("provideStringsForInverter")
    @DisplayName("Invert C-like strings")
    public void shouldReturnInverseString(char[] text, char[] expected) {
        // Given.
        StringInverter sut = new StringInverter();

        char[] invertedText = sut.invert(text);

        assertArrayEquals(expected, invertedText);
    }

    private static Stream<Arguments> provideStringsForInverter() {
        return Stream.of(
                Arguments.of(new char[]{'a', 'b', 'c', '\0'}, new char[]{'c', 'b', 'a', '\0'}),
                Arguments.of(new char[]{'a', 'b', 'c', ' ', '\0'}, new char[]{' ', 'c', 'b', 'a', '\0'}),
                Arguments.of(new char[]{'\0'}, new char[]{'\0'}),
                Arguments.of(new char[]{}, new char[]{})
        );
    }
}
