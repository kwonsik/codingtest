class Solution {
    public String solution(String s) {
        String answer = "";
        String str[] = s.split("");
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length; i++) {
            if(" ".equals(str[i])) {
                index = 0;
                sb.append(str[i]);
            } else {
                if(index%2 == 0) {
                    sb.append(str[i].toUpperCase());
                } else {
                    sb.append(str[i].toLowerCase());
                }
                index++;
            }
        }
        answer = sb.toString();
        
        return answer;
    }
}