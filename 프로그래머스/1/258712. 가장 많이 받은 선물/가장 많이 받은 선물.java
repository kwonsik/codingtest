import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> give = new HashMap<>();
        Map<String, Integer> take = new HashMap<>();
        Map<String, Integer> give_take = new HashMap<>();
        Map<String, Integer> point = new HashMap<>();
        int max = 0;
        // 기본 값
        for(int i=0; i<friends.length; i++) {
            give.put(friends[i], 0);
            take.put(friends[i], 0);
        }
        // 주고 받은 선물 따로 넣기
        for(int i=0; i<gifts.length; i++) {
            String split[] = gifts[i].split(" ");
            give.put(split[0], give.get(split[0]) + 1);
            take.put(split[1], take.get(split[1]) + 1);
            give_take.put(gifts[i], give_take.getOrDefault(gifts[i], 0) + 1);
        }
        
        // 선물 지수
        for(int i=0; i<friends.length; i++) {
            point.put(friends[i], give.get(friends[i]) - take.get(friends[i]));
        }

        
        for (int i = 0; i < friends.length; i++) {
            String A = friends[i];
            int temp = 0; // A가 다음 달에 받을 선물의 수

            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue; // 나 자신과는 비교할 필요 없음

                String B = friends[j];
                
                int aToB = give_take.getOrDefault(A + " " + B, 0); // A가 B에게 준 수
                int bToA = give_take.getOrDefault(B + " " + A, 0); // B가 A에게 준 수
                
                if (aToB > bToA) {
                    temp++;
                } else if (aToB == bToA) {
                    if (point.get(A) > point.get(B)) {
                        temp++;
                    }
                }
            }
            max = Math.max(max, temp);
        }
        
        return max;
    }
}