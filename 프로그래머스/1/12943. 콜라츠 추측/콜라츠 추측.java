class Solution {
    public int solution(int num) {
        int answer = 0;
        int cnt = 0;
        long result = num;
        while(result != 1) {
            result = result % 2 == 0 ? result / 2 : (result * 3) + 1;
            
            if(cnt == 500) {
                answer = -1;
                break;
            }
            cnt ++;
            answer = cnt;
        }
        return answer;
    }
}