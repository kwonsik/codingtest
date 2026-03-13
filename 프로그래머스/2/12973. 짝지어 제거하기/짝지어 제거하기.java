import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        String split[] = s.split("");
        for(String str : split) {
            list.add(str);
            if(list.size() >= 2) {
                if(list.get(list.size()-1).equals(list.get(list.size()-2))) {
                    list.remove(list.size()-2);
                    list.remove(list.size()-1);
                }
            }
        }
        if(list.size() == 0) {
            answer = 1;
        }
        

        return answer;
    }
}