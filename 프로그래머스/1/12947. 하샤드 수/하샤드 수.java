class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        int i = x;
        while(i != 0) {
            int temp = i % 10;
            sum += temp;
            i = i / 10; 
        }
        answer = x % sum == 0 ? true : false;
        return answer;
    }
}