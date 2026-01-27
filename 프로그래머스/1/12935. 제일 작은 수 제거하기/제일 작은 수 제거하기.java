import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int result = 0;
        
        if(arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[arr.length -1];
            result = arr[0];
            for(int i=0; i<arr.length; i++) {
                if(arr[i] < result) {
                    result = arr[i];
                }        
            }
            int index = 0;
            for(int i = 0; i < arr.length; i++) {
            if(arr[i] == result) {
                continue; 
            }
            
            answer[index] = arr[i];
            index++;
        }
        }
        

        
        
        
        
        
        return answer;
    }
}