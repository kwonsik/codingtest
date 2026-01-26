class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long cnt = 0;
        cnt = a - b > 0 ? a - b : b- a;
        answer = (a+b) * (cnt+1) / 2;
        return answer;
    }
}