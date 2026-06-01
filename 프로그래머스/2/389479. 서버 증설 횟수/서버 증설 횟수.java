import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 1;
        ArrayDeque<Integer> deque1 = new ArrayDeque();
        ArrayDeque<Integer> deque2 = new ArrayDeque();
        for(int i=0;i<players.length; i++) {
            if(!deque1.isEmpty()) {
                int temp = deque1.peek();
                if(i == temp + k) {
                    deque1.poll();
                    temp = deque2.poll();
                    server -= temp;
                }
            }
            int temp = players[i];
            int rest = temp % m;
            int need = 0;
            if(rest == 0) {
                need = temp / m + 1;
            } else {
                need = (temp-rest) / m + 1;
            }
            
            if(server < need) {
                // 서버 증설
                int differ = need - server;
                
                server = need;
                answer += differ; 
                deque1.offer(i);
                deque2.offer(differ);

            }
        }
        return answer;
    }
}