import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        String prev = words[0];     
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        for(int i=1; i<words.length; i++) {
            double turn = Math.ceil((double)(i+1)/n);
            int people = (i % n) + 1;
            // 끝말 체크
            if(prev.charAt(prev.length() - 1) != words[i].charAt(0)) {
                answer[0] = people;
                answer[1] = (int)turn;
                break;
            }
            // 중복 체크
            if(map.getOrDefault(words[i], 0) != 0) {
                answer[0] = people;
                answer[1] = (int)turn;
                break;
            }
            
            // 추가
            map.put(words[i], 1);
            prev = words[i];
        }

        

        return answer;
    }
}