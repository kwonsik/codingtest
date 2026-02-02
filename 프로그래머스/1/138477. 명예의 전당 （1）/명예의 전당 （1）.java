import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        // 1. 우선순위 큐 선언 (기본이 오름차순: 작은 게 맨 앞)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < score.length; i++) {
            // 2. 일단 넣습니다. (알아서 정렬됨)
            pq.add(score[i]);
            
            // 3. k개보다 많아지면? 가장 작은 놈(맨 앞)을 제거합니다.
            if (pq.size() > k) {
                pq.poll(); // poll(): 맨 앞의 요소 꺼내서 버리기
            }
            
            // 4. 명예의 전당 최하위 점수 확인 (peek(): 꺼내지는 않고 보기만 함)
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}