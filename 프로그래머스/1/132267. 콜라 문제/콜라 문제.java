class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int result = n;
        int receive = 0; 
        
        while(result >= a) {
            receive = result / a * b; // 받은 병
            result = receive + result % a; // 가지고 있는 병
            answer += receive;
        }
        return answer;
    }
}