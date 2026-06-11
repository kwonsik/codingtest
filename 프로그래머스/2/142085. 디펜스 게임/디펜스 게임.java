import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<enemy.length; i++) {
            n-=enemy[i];
            pq.add(enemy[i]);
            if(n<0) {
                if(k > 0) {
                   k--;
                    n += pq.poll(); 
                } else {
                    return i;
                }
                
            }
        }

        
        return enemy.length; // 끝까지 다 막았을 경우
    }
}