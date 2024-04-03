import java.util.*;

class Solution {
    public ArrayList<Integer>solution(int[] arr) {
        ArrayList<Integer> answer=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            answer.add(arr[i]);
        }
        
        int arr2[]=new int[11];
        int cnt=1;
        int find=-1;
        int cnt2=1;
        for(int i=0;i<arr2.length;i++){
            arr2[i]=cnt;
            cnt*=2;
        }
        for(int i=0;i<arr2.length;i++){
            if(arr2[i]>=arr.length){find=i;break;}
        }
        for(int i=0;i<find;i++){
            cnt2*=2;
        }
       
        for(int i=0;i<cnt2-arr.length;i++){
            answer.add(0);
        }
       
        return answer;
    }
}