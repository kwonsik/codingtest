class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int result1=0;
        int result2=0;
        for(int i=0;i<num_list.length;i++){
            if(i%2==0){result1+=num_list[i];}
            else{result2+=num_list[i];}
        }
        answer=result1>result2?result1:result2;
        return answer;
    }
}