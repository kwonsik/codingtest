class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        String str = "";
        int differ = t.length() - p.length();
        for(int i=0; i<=differ; i++) {
            str = t.substring(i,i+p.length());
            if(Long.parseLong(str) <= Long.parseLong(p)) {
                answer += 1;
            }
        }
        return answer;
    }
}