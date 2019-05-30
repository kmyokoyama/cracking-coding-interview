package br.kmyokoyama.cracking.chapter1;

public class IsUnique {

    public boolean check(String text) {
        int n = 0;

        for (int i = 0; i < text.length(); i++) {
            int charPosition = (int) text.charAt(i); // It uses the ASCII code of the char as its position.

            if ((n & (1 << charPosition)) != 0) { // Note that > 0 would do as well.
                return false;
            }

            n |= 1 << charPosition; // Set bit in that position.
        }

        return true;
    }
}
