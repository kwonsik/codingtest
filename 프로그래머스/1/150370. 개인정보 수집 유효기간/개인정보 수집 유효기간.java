import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies){
        int[] answer = {};
        String split[] = new String[2];
        int year = 0;
        int month = 0;
        int date = 0;
        int differ = 0;
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<terms.length; i++) {
            String str1 = terms[i].substring(0,1);
            String str2 = terms[i].substring(2,terms[i].length());
            map.put(str1, Integer.parseInt(str2)*28);
        }
        System.out.println(map);
        for(int i=0; i<privacies.length; i++) {
            // 현재 날짜와 비교
            split = privacies[i].split(" ");
            String term = split[1];
            year = Integer.parseInt(today.substring(0,4)) - Integer.parseInt(split[0].substring(0,4));
            month = Integer.parseInt(today.substring(5,7)) - Integer.parseInt(split[0].substring(5,7));
            date = Integer.parseInt(today.substring(8,10)) - Integer.parseInt(split[0].substring(8,10));
            differ = year*12*28 + month*28 + date;
            
            
            
            if(differ >= map.get(term)) {
                list.add(i+1);
            } 
            
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}