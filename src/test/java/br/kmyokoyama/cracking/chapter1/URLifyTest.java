package br.kmyokoyama.cracking.chapter1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class URLifyTest {

    @ParameterizedTest(name = "{index} - URL version of \"{0}\" should be \"{1}\"")
    @MethodSource("provideStringForURLify")
    @DisplayName("Transform String in its URL format")
    public void shouldTransformInURLFormat(char[] text, char[] expected) {
        // Given.
        URLify sut = new URLify();

        // When.
        char[] urlFormat = sut.transform(text);

        System.out.println(urlFormat);

        // Then.
        assertArrayEquals(expected, urlFormat);
    }

    private static Stream<Arguments> provideStringForURLify() {
        return Stream.of(
            Arguments.of(
                    new char[]{'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', '\0', ' ', ' ', ' ', ' '},
                    new char[]{'M', 'r', '%', '2', '0', 'J', 'o', 'h', 'n', '%', '2', '0', 'S', 'm', 'i', 't', 'h', '\0'}
            ),
            Arguments.of(
                    new char[]{'a', 'b', ' ', '\0', ' ', ' '},
                    new char[]{'a', 'b', '%', '2', '0', '\0'}
            ),
            Arguments.of(
                    new char[]{' ', '\0', ' ', ' '},
                    new char[]{'%', '2', '0', '\0'}
            ),
            Arguments.of(
                    new char[]{'\0'},
                    new char[]{'\0'}
            )
        );
    }
}
