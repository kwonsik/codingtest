class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String str = String.valueOf(n);
        int length = str.length();
        answer = new int[length];
        int current = 0;
        for(int i = length - 1; i >= 0; i--) {
            answer[i] = str.charAt(current) - 48;
            current++;
        }
        return answer;
    }
}