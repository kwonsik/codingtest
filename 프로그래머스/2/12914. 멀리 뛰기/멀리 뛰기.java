class Solution {
    public long solution(int n) {
        long answer = 0;
        // 모듈러 법칙 + 피보나치? 1 2 3 5
        // 1칸 - 1, 2칸 - 2, 3칸 - 3, 4칸 -5
        int index = 0;
        int a = 0;
        int b = 1;
        int c = 0;
        while(index <= n) {
            a = b;
            b = c;
            c = (a + b) % 1234567;
            index++;
        }
        answer = c;
        return answer;
    }
}