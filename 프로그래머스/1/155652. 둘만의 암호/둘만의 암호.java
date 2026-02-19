class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        char ch = ' ';
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            ch = s.charAt(i);
            while(cnt != index) {
                // skip에 포함 되지 않을 때만 한 칸 이동 후 cnt++
                ch++;
                if(ch > 'z') {
                    ch = (char)((int)ch - 26);
                }
                if(!skip.contains(String.valueOf(ch))) {
                    cnt++;
                }                        
            }
            // cnt 초기화
            if(cnt == index) {
                cnt = 0;
            }
            sb.append(ch);
        }
        answer = sb.toString();
        return answer;
    }
}