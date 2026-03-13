class Solution {
    public int solution(int n) {
        int answer = 0;
        // 0, 1, 1, 2, 3, 5 a + b = c;
        int a = 0; // 0
        int b = 1; // 1
        int c = 1; // 2
        int index  = 2;
        while(index < n) {
            a = b;
            b = c;
            c = (a + b) % 1234567;
            index++;
        }
        return c;
    }
}