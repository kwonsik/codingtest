import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // 대기
        ArrayDeque<Integer> wait = new ArrayDeque<>();
        // 건너는 중
        ArrayDeque<Integer> ing = new ArrayDeque<>();
        // 시간
        ArrayDeque<Integer> timeDeque = new ArrayDeque<>();
        
        for(int i=0; i<truck_weights.length; i++) {
            wait.offer(truck_weights[i]);
        }
        
        int sum = 0;
        
        
        // 대기에서 하나를 뽑아서 다리에 올린다, 그 다음 대기에서 하나를 뽑아서 무게를 체크한 후에 다리에 올린다. while문?
        
        while(true) {
            // 시간 체크
            if(!timeDeque.isEmpty()) {
                int timeTemp = timeDeque.peek();
                if(timeTemp == answer) {
                    int ingTemp = ing.peek();
                    sum -= ingTemp;
                    ing.poll();
                    timeDeque.poll();                 
                }
            }     
            if(!wait.isEmpty()) {
                int waitTemp = wait.peek();
                if(sum + waitTemp <= weight) {
                    wait.poll();
                    ing.offer(waitTemp);
                    sum += waitTemp;                     
                    timeDeque.offer(answer + bridge_length);
                }
            }
            
            answer++;
            if(wait.size() == 0 && ing.size() == 0) {
                break;
            }
        }
        
        
        return answer;
    }
}