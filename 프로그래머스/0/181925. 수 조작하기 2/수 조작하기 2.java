class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        for(int i=0;i<numLog.length-1;i++){
            int result=numLog[i+1]-numLog[i];
            if(result==1){answer+="w";}
            else if(result==-1){answer+="s";}
            else if(result==10){answer+="d";}
            else if(result==-10){answer+="a";}
        }
        return answer;
    }
}