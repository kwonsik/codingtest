import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String str = s.substring(1, s.length()-1);
        String split[] = str.split("},");
        Map<Integer, Integer> map = new HashMap<>();
        for(String a : split) {
            String temp = a.replace("{", "");
            temp = temp.replace("}", "");
            
            String[] numbers = temp.split(",");

            for (String numStr : numbers) {
                int num = Integer.parseInt(numStr);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        answer = new int[map.size()];
        for (Map.Entry<Integer, Integer> elem : map.entrySet()) {
            answer[map.size() - elem.getValue()] = elem.getKey();
        }
        return answer;
    }
}