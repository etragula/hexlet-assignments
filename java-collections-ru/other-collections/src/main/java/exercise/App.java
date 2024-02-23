package exercise;

import java.util.*;

// BEGIN
public class App {

    public static LinkedHashMap<String, String> genDiff(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Map<String, String> sortedResMap = new TreeMap<>();

        // added, deleted, changed или unchanged
        Set<String> firstSet = firstMap.keySet();
        Set<String> secondSet = secondMap.keySet();

        // added
        Set<String> onlyInSecond = new HashSet<>(secondSet);
        onlyInSecond.removeAll(firstSet);
        onlyInSecond.forEach(k -> sortedResMap.put(k, "added"));

        // deleted
        Set<String> onlyInFirst = new HashSet<>(firstSet);
        onlyInFirst.removeAll(secondSet);
        onlyInFirst.forEach(k -> sortedResMap.put(k, "deleted"));

        // changed, unchanged
        Set<String> intersection = new HashSet<>(firstSet);
        intersection.retainAll(secondSet);
        intersection.forEach(k -> sortedResMap.put(
                k,
                firstMap.get(k).equals(secondMap.get(k)) ? "unchanged" : "changed"
        ));

        return new LinkedHashMap<>(sortedResMap);
    }

}
//END
