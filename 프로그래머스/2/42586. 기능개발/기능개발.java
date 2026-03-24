import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        boolean finish[] = new boolean[progresses.length];
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(true) {   
            // 일 진행
            for(int i=0; i<progresses.length; i++) {
                progresses[i] += speeds[i];
                if(progresses[i] >=100) {
                    finish[i] = true;
                }
            }
            
            // 배포 가능 체크
            for(int i=index; i<progresses.length; i++) {
                if(finish[index]) {
                    index++;   
                } else {
                    break;
                }
            }
            if(stack.size() > 0 && stack.peek() != index) {
                stack2.push(index - stack.peek());
            }
            stack.push(index);
            
            if(index == progresses.length) {
                break;
            }
        }
        answer = new int[stack2.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = stack2.get(i);
        }
        return answer;
    }
}