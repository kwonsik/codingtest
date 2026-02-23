class Solution {
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        char ch = ' '; // 첫 글자
        int cnt1 = 0; // 첫 글자와 같은 게 나온 횟수
        int cnt2 = 0; // 첫 글자와 다른 게 나온 횟수
        int length = s.length();
        for(int i=0;i<length; i++) {
            ch = s.charAt(index);
            if(ch == s.charAt(i)) {
                cnt1++;
            } else {
                cnt2++;
            }     
            if(cnt1==cnt2) {
                answer++;
                index = i+1;
                cnt1 = 0;
                cnt2 = 0;
            }           
        }
        
        if(cnt1 != 0 || cnt2 != 0) {
            answer++;
        }
        return answer;
    }
}