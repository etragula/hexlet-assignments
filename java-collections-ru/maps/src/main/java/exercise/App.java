package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sent) {
        HashMap<String, Integer> resMap = new HashMap<>();
        String[] words = sent.split(" ");

        for (String word : words) {
            if (word != null && !word.isBlank()) {
                if (resMap.containsKey(word)) {
                    resMap.compute(word, (k, v) -> ++v);
                } else {
                    resMap.put(word, 1);
                }
            }
        }
        return resMap;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) return "{}";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{\n");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder
                    .append("  ")
                    .append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

}
//END
