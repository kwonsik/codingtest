class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zeroCnt = 0;
        int min = 0;
        int max = 0;
        for(int i=0; i<lottos.length; i++) {
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    cnt++;
                }           
            }
            if(lottos[i] == 0) {
                zeroCnt++;
            }
        }
        
        min = 7 - cnt;
        max = 7 - (cnt + zeroCnt);
        
        // 7등은 없으니 6등으로
        if(min == 7) {
            min = 6;
        }
        if (max == 7) {
            max = 6;
        }
        answer[0] = max;
        answer[1] = min;
        return answer;
    }
}