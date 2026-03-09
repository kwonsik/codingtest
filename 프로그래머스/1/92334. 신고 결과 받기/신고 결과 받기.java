import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        Map<String,Integer> map3 = new HashMap<>();
        List<String> ban = new ArrayList<>(); 
        // 중복 거르기
        for(int i=0; i<report.length; i++) {
            map1.put(report[i], 1);
        }
        // 신고당한 회원 찾기
        for (Map.Entry<String, Integer> entry: map1.entrySet()) {        
            String split[] = entry.getKey().split(" ");
            
            int temp = map2.getOrDefault(split[1],0);
            map2.put(split[1], temp + 1);
            
        }
        
        // 정지당한 회원 찾기
        for (Map.Entry<String, Integer> entry: map2.entrySet()) {
            int cnt = entry.getValue();
            if(cnt >= k) {
                ban.add(entry.getKey());
            }
        }
        // 메일 발송 찾기
        for (Map.Entry<String, Integer> entry: map1.entrySet()) { 
            String split[] =  entry.getKey().split(" ");
            String from =  split[0];
            String to =  split[1];
            for(int i=0; i<ban.size(); i++) {
                if(to.equals(ban.get(i))) {
                    map3.put(from, map3.getOrDefault(from, 0) + 1);
                }
            }
        }
        answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            answer[i] = map3.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}