import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for(int amount : d) {
            if(budget - amount >= 0) {
                budget -= amount;
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}