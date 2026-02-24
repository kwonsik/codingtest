import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];       
        
        Map<Character, Integer> map = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                int presses = i + 1;
                if (map.containsKey(ch)) {
                    map.put(ch, Math.min(map.get(ch), presses));
                } else {
                    map.put(ch, presses);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            boolean isPossible = true;    
            for (int j = 0; j < targets[i].length(); j++) {
                char ch = targets[i].charAt(j);

                if (map.containsKey(ch)) {
                    sum += map.get(ch);
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            answer[i] = isPossible ? sum : -1;
        }
        return answer;
    }
}