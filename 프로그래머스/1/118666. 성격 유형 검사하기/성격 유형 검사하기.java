import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String str[] = {"RT", "CF", "JM", "AN"};
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>(); 
        for(int i=0; i<survey.length; i++) {
            char ch1 = survey[i].charAt(0);
            char ch2 = survey[i].charAt(1);
            int choice = choices[i];
            if(choice < 4) {
                map.put(ch1, map.getOrDefault(ch1, 0) + (4-choice));
            } else if(choice > 4) {
                map.put(ch2, map.getOrDefault(ch2, 0) + (choice-4));
            }
        }
        for(int i=0; i<str.length; i++) {
            char ch1 = str[i].charAt(0);
            char ch2 = str[i].charAt(1);
            if(map.getOrDefault(ch1, 0) > map.getOrDefault(ch2, 0)) {
                sb.append(ch1);
            } else if(map.getOrDefault(ch1, 0) < map.getOrDefault(ch2, 0)) {
                sb.append(ch2);
            } else {
               sb.append((char)Math.min(ch1, ch2));
            }
        }
        
        answer = sb.toString();
        return answer;
    }
}