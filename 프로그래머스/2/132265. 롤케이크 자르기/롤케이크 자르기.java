import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> chulsoo = new HashSet<>(); 
        
        Map<Integer, Integer> brother = new HashMap<>(); 
        
        for (int t : topping) {
            brother.put(t, brother.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            
            chulsoo.add(t); 
            
            brother.put(t, brother.get(t) - 1);
            
            if (brother.get(t) == 0) {
                brother.remove(t);
            }
            
            if (chulsoo.size() == brother.size()) {
                answer++;
            }
        }
        
        
        return answer;
    }
}