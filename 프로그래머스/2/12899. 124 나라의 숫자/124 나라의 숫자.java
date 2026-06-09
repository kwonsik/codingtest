class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] nums = {"4", "1", "2"};

        while (n > 0) {
            int remainder = n % 3; 
            n /= 3;                
            if (remainder == 0) {
                n -= 1;
            }

            answer.insert(0, nums[remainder]);
        }

        return answer.toString();
    }
}