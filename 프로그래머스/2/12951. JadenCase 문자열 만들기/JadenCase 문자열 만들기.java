import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String split[] = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        
        for(String str : split) {
            String temp = str.toLowerCase();
            if("".equals(str)) {
                sb.append(" ");
                continue;
            }
            
            
            char ch1 = temp.charAt(0);
            // 맨 앞이 숫자가 아니라면 
            if(!(ch1 >= '0' && ch1 <= '9')) {
                char ch2 = temp.charAt(0);
                ch2 =(char) (ch2 - 32);
                temp = ch2 + temp.substring(1,temp.length());
            }
            sb.append(temp);
            sb.append(" ");
        }
        
        answer = sb.toString();
        answer = answer.substring(0, answer.length() - 1);
        
        return answer;
    }
}