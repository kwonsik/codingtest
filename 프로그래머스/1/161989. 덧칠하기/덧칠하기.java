class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int lastIndex = 0;
        for (int s : section) {
            if (s > lastIndex) {
                answer++;
                lastIndex = s + m - 1;
            }
        }
        
        return answer;
    }
}