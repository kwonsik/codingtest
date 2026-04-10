import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;        
       
        for(String str : skill_trees) {
            ArrayDeque<Character> queue = new ArrayDeque<>();
            for(char ch : skill.toCharArray()) {
                queue.offer(ch);
            }
            for(char ch : str.toCharArray()) {
                if(queue.contains(ch)) {
                    if(queue.poll() != ch) {
                        answer--;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}