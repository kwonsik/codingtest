import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int cnt = 0; 
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map1.put(want[i], number[i]);
            cnt += number[i];
        }
        
        for(int i=0; i<discount.length; i++) {
            map2.clear();
            for(int j=i; j<i + cnt; j++) {
                if(i+cnt > discount.length) {
                    break;
                }
                // discount항목 넣어서 map1과 비교
                map2.put(discount[j], map2.getOrDefault(discount[j], 0) + 1);
            }
            
            if(map2.entrySet().containsAll(map1.entrySet())) {
                answer++; 
            }
            
        }
        
        return answer;
    }
}