class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        String str[][]=new String[my_string.length()/m][m];
        int cnt=0;
        for(int i=0;i<my_string.length()/m;i++){
            for(int j=0;j<m;j++){
                str[i][j]=String.valueOf(my_string.charAt(cnt));
                cnt++;
            }
        }
        for(int i=0;i<str.length;i++){
            answer+=str[i][c-1];
        }
        return answer;
    }
}