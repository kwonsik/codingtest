class Solution {
    public int solution(int n) {
        int targetCount = Integer.bitCount(n);
        
        int answer = n + 1;
        while (true) {
            if (Integer.bitCount(answer) == targetCount) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}