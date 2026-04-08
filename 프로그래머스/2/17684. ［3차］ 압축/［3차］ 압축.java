import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        char ch = 'A';
        for(int i = 1; i <= 26; i++) {
            map.put(String.valueOf(ch), i);
            ch++;
        }
        
        int index = 27; 
        
        for(int i = 0; i < msg.length(); ) {
            StringBuilder w = new StringBuilder();
            w.append(msg.charAt(i));
            
            int j = i + 1;
            
            while(j < msg.length() && map.containsKey(w.toString() + msg.charAt(j))) {
                w.append(msg.charAt(j));
                j++;                   
            }
            
            list.add(map.get(w.toString()));
            
            if(j < msg.length()) {
                map.put(w.toString() + msg.charAt(j), index);
                index++;
            }
            
            i = j; 
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}