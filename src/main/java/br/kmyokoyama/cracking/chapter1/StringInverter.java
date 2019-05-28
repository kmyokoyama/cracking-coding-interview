package br.kmyokoyama.cracking.chapter1;

public class StringInverter {

    public char[] invert(char[] text) {
        if (text.length == 0) {
            return new char[]{};
        }

        int size = strlen(text); // This is O(n).

        char[] invertedText = new char[size + 1]; // Accounting for '\0'.
        int i, j = 0;
        for (i = size - 1, j = 0; i >= 0; i--, j++) { // This is also O(n).
            invertedText[j] = text[i];
        }

        invertedText[j] = '\0'; // Variable j holds its last value after iteration.

        return invertedText;
    }

    private int strlen(char[] text) {
        int i = 0;

        while (text[i] != '\0') {
            i++;
        }

        return i;
    }
}
