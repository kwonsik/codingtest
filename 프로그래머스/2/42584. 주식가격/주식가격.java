import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 가격이 아직 떨어지지 않은 주식의 '인덱스(초)'를 기억할 스택
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            // 스택에 대기 중인 주식이 있고, 지금 가격이 대기 중인 가격보다 떨어졌다면!
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                // 대기 중이던 주식의 인덱스를 꺼냅니다.
                int index = stack.pop();
                // 가격이 떨어지기까지 버틴 시간 = 현재 시간(i) - 들어간 시간(index)
                answer[index] = i - index;
            }
            // 아직 가격이 떨어지지 않은 현재 시간(i)도 스택에 들어가서 대기합니다.
            stack.push(i);
        }
        
        // 배열을 다 돌았는데도 끝까지 안 떨어진 끈질긴 녀석들 정산
        while (!stack.isEmpty()) {
            int index = stack.pop();
            // 전체 시간(끝 인덱스) - 들어간 시간(index)
            answer[index] = (prices.length - 1) - index;
        }
        
        return answer;
    }
}