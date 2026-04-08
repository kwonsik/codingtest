class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        // 0 1 10 11 100 101 110 111 1000 1001 1010 1011 1100 1101 1110 1111 ....
        // 튜브의 순서까지만 구한다?
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        int length = t * m;
        while(true) {
            
            sb.append(Integer.toString(cnt, n));
            cnt++;
            // 길이를 충족하면 break;
            
            if(sb.length() > length) {
                break;
            }
        }
        String str = sb.toString().toUpperCase();
        System.out.println(str);
        cnt = 0;
        while(cnt < t) {
            answer+= str.charAt(cnt * m + p - 1);
            cnt++;
        }
        return answer;
    }

}