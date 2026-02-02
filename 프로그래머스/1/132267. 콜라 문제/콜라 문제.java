class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int result = n;
        int receive = 1; 
        int cnt = 0;
        while(receive != 0) {
            receive = result / a * b; // 받은 병
            result = receive + result % a; // 가지고 있는 병
            answer += receive;
        }
        return answer;
    }
}