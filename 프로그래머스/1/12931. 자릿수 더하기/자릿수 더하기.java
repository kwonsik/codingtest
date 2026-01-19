import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String number = Integer.toString(n); 
        int length = number.length();
        for(int i = 0; i < length; i++) {
            System.out.println(number.charAt(i));
            int tempNum = Character.getNumericValue(number.charAt(i));
            answer += tempNum;
        }

        return answer;
    }
}