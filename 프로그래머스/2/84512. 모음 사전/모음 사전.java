import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    
    String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("", 0);

        return dictionary.indexOf(word);
    }
    
    public void dfs(String str, int len) {
        
        dictionary.add(str);
        
        if (len == 5) return;
       
        for (int i = 0; i < 5; i++) {
            
            dfs(str + vowels[i], len + 1);
        }
    }
}