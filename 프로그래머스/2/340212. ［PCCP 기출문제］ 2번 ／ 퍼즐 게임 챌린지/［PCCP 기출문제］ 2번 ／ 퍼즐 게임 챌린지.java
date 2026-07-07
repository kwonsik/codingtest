import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (isPossible(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        
        return answer;
    }
    
    private boolean isPossible(int[] diffs, int[] times, long limit, int level) {
        long sum = 0;
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int time = times[i];
            
            if (diff <= level) {
                sum += time;
            } else {
                long temp = times[i] + times[i - 1];
                sum += temp * (diff - level) + time;
            }
            
            if (sum > limit) {
                return false;
            }
        }
        return sum <= limit;
    }
}