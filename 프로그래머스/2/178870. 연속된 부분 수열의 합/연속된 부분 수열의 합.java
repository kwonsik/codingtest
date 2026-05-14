class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while (right < sequence.length) {
            
            if (sum == k) {
                int currentLength = right - left;
                
                if (currentLength < minLength) {
                    minLength = currentLength;
                    answer[0] = left;
                    answer[1] = right;
                }
                
                sum -= sequence[left];
                left++;
                
            } else if (sum > k) {
                sum -= sequence[left];
                left++;
                
            } else { 
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            }
        }
        
        return answer;
    }
}