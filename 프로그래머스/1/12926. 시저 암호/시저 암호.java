class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char ch = ' ';
        for(int i=0; i<s.length(); i++) {
            ch = s.charAt(i);
            // 소문자
            if(Character.isLowerCase(ch)) {        
                if(ch + n > 'z') { 
                    ch = (char)(ch + n - 26);                    
                } else {
                    ch = (char)(ch + n);
                }
            } 
            
            if(Character.isUpperCase(ch)) {
                if(ch + n > 'Z') {
                    ch = (char)(ch + n  - 26);
                } else {
                    ch = (char)(ch + n);
                }
            }        
            sb.append(ch);
            
        }
        answer = sb.toString();
        return answer;
    }
}