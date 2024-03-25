import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int arr[]) {
        ArrayList<Integer> answer = new ArrayList<>();
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i];j++){
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}