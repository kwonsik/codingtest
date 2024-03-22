class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int result1=0;
        String str="";
        result1=2*a*b;
        str=""+a+b;
        int result2=Integer.parseInt(str);
        answer=result1>result2?result1:result2;
        return answer;
    }
}