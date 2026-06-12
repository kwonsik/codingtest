import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            list.add(i); 
            factorial *= i;
        }     
        k--;         

        for (int i = 0; i < n; i++) {

            factorial /= (n - i);
            
            int idx = (int) (k / factorial);
            
            answer[i] = list.remove(idx);
            
            k %= factorial;
        }
        
        return answer;
    }
}