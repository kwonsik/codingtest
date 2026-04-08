import java.util.*;

class Solution {
    public int[] solution(String msg) {

        ArrayList<Integer> answerList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        char ch = 'A';
        
        for(int i=1; i<=26; i++) {
            map.put(String.valueOf(ch), i);
            ch++;
        }
        
        int index = 27;
        
        for(int i=0; i< msg.length(); i++) {
            String str = "";
            char temp1 = msg.charAt(i);
            str += temp1;
            
            boolean isEnd = true;
            
            for(int j=i+1; j<msg.length(); j++) {
                char temp2 = msg.charAt(j);
                str += temp2;
                
                int num = map.getOrDefault(str, 0);
                
                if(num == 0) {
                    String w = str.substring(0, str.length() - 1); 
                    answerList.add(map.get(w));
                    
                    map.put(str, index);
                    index++;
                    
                    i = j - 1;
                    isEnd = false; 
                    break;
                }
            }
            
            if(isEnd) {
                answerList.add(map.get(str));
                break;
            }
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}