class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String str = s.toUpperCase();
        int pCnt = 0;
        int yCnt = 0;
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'P') {
                pCnt++;
            } else if(c == 'Y') {
                yCnt++;
            } 
        }
        answer = pCnt == yCnt;

        return answer;
    }
}