import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean isVisit[] = new boolean[numbers.length()];
        dfs("", numbers, isVisit);
        
        int answer = 0;
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(String current, String numbers, boolean[] isVisit) {
        
        if(!"".equals(current)) {
            set.add(Integer.parseInt(current));
        }
            
        for(int i=0; i<numbers.length(); i++) {
                if(!isVisit[i]) {
                    isVisit[i] = true; 
                    System.out.println("current : " + current);
                    dfs(current + numbers.charAt(i), numbers, isVisit);
                    isVisit[i] = false;
                }
            }
        
    }
    
    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false; 
        }
        return true;
    }
}