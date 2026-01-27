import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);
        int index = 0;
        for(int i=arr.length-1; i>=0; i--) {
            sb.append((char) arr[i]);
            index++;
        }
        answer = sb.toString();
        return answer;
    }
}