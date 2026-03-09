import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int nowHealth = health;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<attacks.length; i++) {
            map.put(attacks[i][0], attacks[i][1]);
        }
        int last = attacks[attacks.length-1][0];
        int time = 1;
        int cnt = 0;
        while(last >= time) {
            int attack = map.getOrDefault(time, 0);
            // 공격을 받았다면
            if(attack != 0) {
                // 연속 성공 초기화
                cnt = 0;
                // 체력 감소
                nowHealth -= attack;
                // 체력이 0이하라면
                if(nowHealth<=0) {
                    nowHealth = -1;
                    break;
                }
            } else {
                // 연속 성공
                cnt++;
                // 기본 회복
                nowHealth += bandage[1];
                // 추가 회복
                if(cnt == bandage[0]) {
                    nowHealth += bandage[2];
                    // 연속 성공 초기화
                    cnt = 0;
                }
                // 최대 체력 계산
                if(nowHealth > health) {
                    nowHealth = health;
                }
            }
            
            time++;
        }
        answer = nowHealth;
        return answer;
    }
}