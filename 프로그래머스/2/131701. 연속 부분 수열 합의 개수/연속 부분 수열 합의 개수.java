import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int cnt = 1;
        while(cnt <= elements.length) {
            for(int i=0; i<elements.length; i++) {
                int sum = 0;
                for(int j=i; j<i+cnt; j++) {
                    int temp = j;
                    if(temp>elements.length - 1) {
                        temp -= elements.length;
                    }
                    sum += elements[temp];
                }
                set.add(sum);
            }    
            cnt++;
        }
        answer = set.size();
        return answer;
    }
}