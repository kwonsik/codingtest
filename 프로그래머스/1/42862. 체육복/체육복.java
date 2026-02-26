import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++) {
            map.put(i,1);
        }
        map.put(0,-1);
        map.put(n+1,-1);
        for(int i=0; i<lost.length; i++) {
            int temp = lost[i];
            map.put(temp, map.get(temp)-1);
        }
        for(int i=0; i<reserve.length; i++) {
            int temp = reserve[i];
            map.put(temp, map.get(temp)+1);
        }
        
        // 빌려주는 작업
        for (Integer key : map.keySet()) {
            if (map.get(key) == 0) {
                if(map.get(key-1) == 2) {
                    map.put(key, map.get(key) + 1);
                    map.put(key-1, map.get(key-1) - 1);
                } else if(map.get(key+1) == 2) {
                    map.put(key, map.get(key) + 1);
                    map.put(key+1, map.get(key+1) - 1);
                }
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > 0) {
                answer++;
            }
        }
        return answer;
    }
}