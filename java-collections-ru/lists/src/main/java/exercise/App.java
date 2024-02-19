package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String s1, String s2) {
        int[] letters = new int[128];

        char[] s2CharArray = s2.toLowerCase().toCharArray();
        for (char c : s2CharArray) {
            letters[c]++;
        }

        for (char c : s1.toLowerCase().toCharArray()) {
            if (letters[c] != 0) {
                letters[c]--;
            }
        }

        for (int letter : letters) {
            if (letter != 0) return false;
        }

        return true;
    }
}
//END
