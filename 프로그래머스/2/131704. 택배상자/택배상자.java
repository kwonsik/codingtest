import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int cnt = 1;
        // 보조 벨트
        Stack<Integer> belt = new Stack<>();
        // 트럭
        Stack<Integer> truck = new Stack<>();
        for(int i=order.length-1; i>=0; i--) {
            truck.add(order[i]);
        }
        
        while(cnt <= order.length) {
            
            // 트럭에 맞는지 확인
            if(cnt == truck.peek()) {
                answer++;
                truck.pop();
            } else {
                belt.add(cnt);
            }

            while(belt.size() > 0 && belt.peek().equals(truck.peek())) {
                belt.pop();
                truck.pop();
                answer++;
            }      
            // 다음 화물
            cnt++;
        }
        return answer;
    }
}