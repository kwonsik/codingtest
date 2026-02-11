import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int cnt = 0;
        cnt = score.length/m;
        int index = 0;
        for(int i=0; i<cnt; i++) {
            for(int j=(score.length-1) - i*m; j> (score.length-1-m) - i*m; j--) {
                index++;
                if(index % m == 0) {
                    answer += score[j] * m;
                }
                
            }
        }
        return answer;
    }
}