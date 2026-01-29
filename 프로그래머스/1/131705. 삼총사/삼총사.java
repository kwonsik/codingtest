class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        // n개일 때 0~4
        // 012 013 .... 234
        for(int i=0; i<number.length -2; i++) {
            for(int j=i+1; j<number.length -1; j++) {
                for(int k=j+1; k<number.length; k++) {
                    if(number[i] + number[j] + number[k] == 0) {
                        answer += 1;
                    }
                }
            } 
        }
        return answer;
    }
}