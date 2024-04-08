import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        
        ArrayList<Integer> answer=new ArrayList<Integer>();
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==2){
                al.add(i);
            }
        }
        if(al.size()!=0){
            for(int i=al.get(0);i<=al.get(al.size()-1);i++){
            answer.add(arr[i]);
        }
        }
        else{
            answer.add(-1);
        }
        
        return answer;
    }
}