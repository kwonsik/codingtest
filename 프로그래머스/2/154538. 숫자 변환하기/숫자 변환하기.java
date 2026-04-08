import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        set.add(x);
        while(!set.contains(y)) {
            Set<Integer> set2 = new HashSet<>();
            Iterator<Integer> iterator = set.iterator();
            while(iterator.hasNext()) {
	            int temp = iterator.next();
                set2.add(temp + n);
                set2.add(temp * 2);
                set2.add(temp * 3);
            }
            set = set2;
            // set의 모든 요소가 y보다 크면 break;
            Iterator<Integer> iterator2 = set.iterator();
            int min = 1000001;
            while(iterator2.hasNext()) {
	            int temp = iterator2.next();
                min = Math.min(min, temp);
            }
            if(min > y) {
                return -1;
            }
            answer++;
        }
        return answer;
    }
}