import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        List<String> list = new ArrayList<>();
        
        for(String str : cities) {
            String temp = str.toLowerCase();

            if(list.contains(temp)) {
                list.remove(temp); 
                list.add(temp);    
                answer += 1;
            } 
            else {
                if(list.size() >= cacheSize) { 
                    list.remove(0); 
                }
                list.add(temp);
                answer += 5;
            }
        }
        return answer;
    }
}