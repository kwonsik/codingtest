import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if(i>0) {
                if(arr[i] == arr[i-1]) {
                    cnt++;
                }   
            }
        }
        answer = new int[arr.length-cnt];
        int index = 0;
        for(int i=0; i<arr.length; i++) {
            if(i>0) {
                if(arr[i] != arr[i-1]) {
                    answer[index] = arr[i];
                    index++;
                }   
            } else {
                answer[0] = arr[0];
                index++;
            }
        }
        return answer;
    }
}