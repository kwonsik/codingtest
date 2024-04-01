import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(n);
        for(;;){
            if(n%2==0){n=n/2;}
            else if(n%2==1){n=n*3+1;}
            answer.add(n);
            
            if(n==1){break;}
        }
        
        return answer;
    }
}