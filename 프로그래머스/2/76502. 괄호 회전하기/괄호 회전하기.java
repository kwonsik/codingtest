import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String str = s;
        // s를 돌아가면서 한칸씩 당긴다
        for(int i=0; i<s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            str = str.substring(1, str.length()) + str.charAt(0);
            for(char ch : str.toCharArray()) {
            char temp = ' ';
            if(stack.size() != 0) {
                temp = stack.peek();
            }
            boolean isPop = false;
            if(ch == ']') {
                if(temp == '[') {
                   isPop = true; 
                } 
            } else if(ch == ')') {
                if(temp == '(') {
                   isPop = true; 
                }                
            } else if(ch == '}') {
                if(temp == '{') {
                   isPop = true; 
                } 
            }
            
            if(isPop) {
                stack.pop();
            } else {
                stack.push(ch);
            }
            
        }
        
        if(stack.size() == 0) {
            answer++;
        }
        }
            
  
        
        
        return answer;
    }
}