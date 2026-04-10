class Solution {
    public int solution(int n) {
        int answer = 0;
        // 4 -> 1111, 112, 22    3 -> 111 12,   5 -> 11111 1112 122, 6 -> 111111 11112 1122 222 7 -> 1111111 111112 11122 1222
        // 8 -> 11111111, 1111112, 111122, 11222, 2222 1+7+15+10+1 
        // 1, 2, 3, 5, 8, 13, 21, 34
        long a = 1;
        long b = 2;
        long c = 3;
        int cnt = 4;
        while(cnt <= n) {
            a = b;
            b = c;
            c = (a+b) % 1000000007;
            cnt++;
        }
        answer = (int)c;
        return answer;
    }
}