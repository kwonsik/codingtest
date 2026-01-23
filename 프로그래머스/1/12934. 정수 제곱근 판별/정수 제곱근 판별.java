class Solution {
    public long solution(long n) {
        long answer = 0;
        long current = 1;
        while(n > current * current) {
            current++;     
        }
        answer = n == current * current ? (current + 1) * (current + 1) : -1;
        return answer;
    }
}