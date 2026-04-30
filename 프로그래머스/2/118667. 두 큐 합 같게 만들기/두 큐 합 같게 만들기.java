import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        // 1. 오버플로우 방지를 위해 반드시 long으로 선언!
        long sum1 = 0; 
        long sum2 = 0;
        
        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        
        for(int i = 0; i < queue1.length; i++) {
            deque1.offer(queue1[i]);
            deque2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if((sum1 + sum2) % 2 == 1) {
            return -1;
        }

        int limit = queue1.length * 4; 
        while(answer <= limit) {
            if(sum1 == sum2) {
                return answer; 
            }
            
            if(sum1 > sum2) {
                int temp = deque1.poll();
                deque2.offer(temp);
                sum1 -= temp;
                sum2 += temp;
            } else { 
                int temp = deque2.poll();
                deque1.offer(temp);
                sum2 -= temp;
                sum1 += temp;
            }
            answer++; 
        }
        
        return -1;
    }
}