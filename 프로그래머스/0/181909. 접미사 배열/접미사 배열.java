import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        for(int i=0;i<answer.length;i++){
            String result="";
            for(int j=i;j<answer.length;j++){
                result+=my_string.charAt(j);
            }
            answer[i]=result;
        }
        Arrays.sort(answer);
        return answer;
    }
}