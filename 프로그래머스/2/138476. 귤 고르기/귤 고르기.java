import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i : tangerine) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        
        // 최대 갯수 순으로 나열해서 더한 게 k이상인 순간이 최소 종류
        for (Map.Entry<Integer, Integer> entry: map1.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);

        int sum = 0;
        for(int i=list.size() -1; i>=0; i--) {
            sum += list.get(i);
            answer ++;
            if(sum >= k) {
                break;
            }
        }
        return answer;
    }
}