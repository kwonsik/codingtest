import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        // 5 `-> 4 -> 2 -> 1 `-> 0
        // 6 -> 3 `-> 2 -> 1 `-> 0
        int number = n;
        int cnt = 0;
        while(number != 0) {
            if(number % 2 != 0) {
                number--;
                ans++;
            } else {
                number /= 2;
            }
        }
        return ans;
    }
}