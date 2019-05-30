package br.kmyokoyama.cracking.chapter1;

public class URLify {

    public char[] transform(char[] text) {
        int i = 0;
        int j = 0;
        int size = 0;

        while (text[size] != '\0') {
            size++;
        }

        i = size;
        j = text.length - 1;

        while (i >= 0) {
            if (text[i] == ' ') {
                text[j--] = '0';
                text[j--] = '2';
                text[j--] = '%';
                i--;
            }

            if (i >= 0) {
                text[j] = text[i];
                i--;
                j--;
            }
        }

        return text;
    }
}
