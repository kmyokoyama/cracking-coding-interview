package br.kmyokoyama.cracking.chapter1;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public boolean check(String str1, String str2) {
        Map<Character, Integer> counter1 = new HashMap<>();
        Map<Character, Integer> counter2 = new HashMap<>();

        for (char c : str1.toCharArray()) {
            counter1.put(c, counter1.getOrDefault(c,0));
        }

        for (char c : str2.toCharArray()) {
            counter2.put(c, counter1.getOrDefault(c,0));
        }

        return counter1.equals(counter2);
    }
}
