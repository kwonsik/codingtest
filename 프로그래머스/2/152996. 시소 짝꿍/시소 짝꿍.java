class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] count = new long[1001]; 
        
        for(int w : weights) {
            count[w]++;
        }
        

        for(int i = 100; i <= 1000; i++) {
            if(count[i] == 0) continue;
            

            answer += (count[i] * (count[i] - 1)) / 2;

            if(i * 3 % 2 == 0 && (i * 3 / 2) <= 1000) {
                answer += count[i] * count[i * 3 / 2];
            }
            
            if(i * 4 % 3 == 0 && (i * 4 / 3) <= 1000) {
                answer += count[i] * count[i * 4 / 3];
            }
            
            if(i * 2 <= 1000) {
                answer += count[i] * count[i * 2];
            }
        }
        
        return answer;
    }
}