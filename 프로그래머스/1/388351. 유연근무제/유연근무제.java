import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=0; i<schedules.length; i++) {
            int today = startday; 
            
            int schedMin = (schedules[i] / 100) * 60 + (schedules[i] % 100);
            int targetMin = schedMin + 10;
            
            for(int j=0; j<timelogs[i].length; j++) {
                if(!(today == 6 || today == 7)) {
                    int logMin = (timelogs[i][j] / 100) * 60 + (timelogs[i][j] % 100);
                    
                    if(logMin > targetMin) {
                        map.put(i, false);
                    }
                }
                
                today++;
                if(today > 7) {
                    today -= 7;
                }
            }
        }
        answer = schedules.length - map.size();
        return answer;
    }
}