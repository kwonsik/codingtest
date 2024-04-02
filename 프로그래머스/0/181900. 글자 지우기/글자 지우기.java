import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        Arrays.sort(indices);
        String arr[]=new String[my_string.length()];
        
        for(int i=0;i<my_string.length();i++){
            arr[i]=String.valueOf(my_string.charAt(i));
        }
        for(int i=0;i<indices.length;i++){
            arr[indices[i]]="";
        }
        for(int i=0;i<my_string.length();i++){
            answer+=arr[i];
        }
        return answer;
    }
}