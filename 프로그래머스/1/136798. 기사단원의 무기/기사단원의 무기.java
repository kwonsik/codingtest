import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int cnt = 0;
        int result = 0;
        double sqrt = 0;
        List<Integer> list = new ArrayList<>(); 
        for(int i=1; i<=number; i++) {
            cnt = 0;
            sqrt = Math.sqrt((double)i);
            for(int j=1; j<=sqrt; j++) {              
                if(i % j ==0) {
                    cnt++;
                    if(j == sqrt) {
                        result = (cnt)*2 - 1;
                    } else {
                        result = cnt*2;
                    }
                }               
            } 
            list.add(result);
        }
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) > limit) {
                answer += power;
            } else {
                answer += list.get(i);
            }
        }
        return answer;
    }
}