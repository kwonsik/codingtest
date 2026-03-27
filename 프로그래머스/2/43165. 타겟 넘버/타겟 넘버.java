import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // 최초의 누적값 0으로 시작!

        // 1. numbers 배열의 숫자를 하나씩 차례대로 꺼내옵니다.
        for (int i = 0; i < numbers.length; i++) {
    
            // 2. 현재 큐에 들어있는 '이전 단계까지의 누적값'들이 몇 개인지 확인합니다.
            int currentSize = queue.size(); 
    
            // 3. 큐에 들어있던 개수만큼만 딱 반복해서 꺼냅니다!
            for (int j = 0; j < currentSize; j++) {
                int temp = queue.poll(); // 이전 단계의 누적값 하나 꺼내기
        
                // 4. 꺼낸 누적값에 이번 숫자(numbers[i])를 더하고 뺀 결과를 다시 큐에 예약!
                queue.offer(temp + numbers[i]);
                queue.offer(temp - numbers[i]);
            }
        }
        while(queue.size() != 0) {
            if(queue.poll() == target) {
                answer++;
            }
        }
        return answer;
    }
}