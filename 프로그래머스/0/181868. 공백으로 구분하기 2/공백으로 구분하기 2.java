class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        String[] result={};
        int cnt=0;
        answer=my_string.split(" ");
        
        for(int i=0;i<answer.length;i++){
            if(!answer[i].equals("")){
                cnt++;
            }
        }
        result=new String[cnt];
        cnt=0;
        for(int i=0;i<answer.length;i++){
            if(!answer[i].equals("")){
                result[cnt]=answer[i];
                cnt++;
            }
        }
        answer=result;
        return answer;
    }
}