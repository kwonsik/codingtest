class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int i=0;i<num_list.length;i++){
            int result=num_list[i];
            for(;;){
                if(result%2==0){result=result/2;answer+=1;}
                else if(result!=1&&result%2==1){result=(result-1)/2;answer+=1;}
                else if(result==1){break;}
                
            }
        }
        return answer;
    }
}