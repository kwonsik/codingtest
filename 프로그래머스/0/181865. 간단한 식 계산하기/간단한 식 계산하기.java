import java.util.*;

class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String arr[]=new String[2];
        if(binomial.contains("+")){
            arr=binomial.split("\\+");
            String result=arr[0]+arr[1];
            
            arr=result.split("  ");
            answer=Integer.parseInt(arr[0])+Integer.parseInt(arr[1]);
        }
        else if(binomial.contains("-")){
            arr=binomial.split("\\-");
            String result=arr[0]+arr[1];
            
            arr=result.split("  ");
            answer=Integer.parseInt(arr[0])-Integer.parseInt(arr[1]);
        }
        else if(binomial.contains("*")){
            arr=binomial.split("\\*");
            String result=arr[0]+arr[1];
            
            arr=result.split("  ");
            answer=Integer.parseInt(arr[0])*Integer.parseInt(arr[1]);
        }
        return answer;
    }
}