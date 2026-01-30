class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int index=0;
        
        for(int i=0; i<s.length(); i++) {
            if(answer[i] == 0) {
                answer[i] = -1;
            }
            for(int j=i+1; j<s.length(); j++) {
                // i 번째 글짜와 j 번째 글자 비교 후 break
                if(s.charAt(i) == s.charAt(j)) {
                    index = j - i;
                    answer[j] = index;                     
                    break;                  
                }         
            }
            
        }
        return answer;
    }
}