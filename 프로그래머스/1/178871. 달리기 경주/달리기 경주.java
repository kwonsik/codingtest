import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            map1.put(players[i], i);
            map2.put(i, players[i]);
        }
        for(int i=0; i<callings.length; i++) {
            // 불린 사람 등수 올리고
            String call = callings[i];
            map1.put(call, map1.get(call) - 1);          
            
            // 앞이었던 사람 등수 내리고      
            String target = map2.get(map1.get(call));
            map1.put(target, map1.get(target) + 1);
            
            
            // map2도 재설정
            map2.put(map1.get(call), call);
            map2.put(map1.get(target), target);

        }
        for (Map.Entry<String, Integer> entry: map1.entrySet()) {
            answer[entry.getValue()] = entry.getKey(); 
        }
        return answer;
    }
}