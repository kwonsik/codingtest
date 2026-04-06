class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        
        
        String[] parts = str.split("0");
        
        for (String part : parts) {
           
            if (part.equals("")) continue;
            
            long num = Long.parseLong(part);
            
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num <= 1) return false;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; 
            }
        }
        return true;
    }
}