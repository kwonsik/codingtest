class Solution {
    public int solution(String number) {
        int answer = 0;
        
        for(int i=0;i<number.length();i++){
            String str=""+number.charAt(i);
            answer+=Integer.parseInt(str);
            answer=answer%9;
        }
        
        return answer;
    }
}