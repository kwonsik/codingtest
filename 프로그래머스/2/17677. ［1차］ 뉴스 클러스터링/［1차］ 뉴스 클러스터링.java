import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        Map<String, Integer> map1 = makeMap(str1);
        Map<String, Integer> map2 = makeMap(str2);

        if (map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }

        double intersection = 0;
        double union = 0;

        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);

            // 다중집합 교집합: min(count1, count2)
            intersection += Math.min(count1, count2);
            // 다중집합 합집합: max(count1, count2)
            union += Math.max(count1, count2);
        }

        if (union == 0) return 65536;

        double jaccard = intersection / union;
        return (int) (jaccard * 65536);
    }

    private Map<String, Integer> makeMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.toLowerCase(); 

        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                String pair = "" + c1 + c2;
                map.put(pair, map.getOrDefault(pair, 0) + 1);
            }
        }
        return map;
    }
}