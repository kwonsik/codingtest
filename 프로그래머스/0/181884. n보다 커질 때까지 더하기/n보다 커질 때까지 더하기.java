class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for(int i=0;i<=n;i++){
            answer+=numbers[i];
            if(answer>n){break;}
        }
        return answer;
    }
}