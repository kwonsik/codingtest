class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for(int i=0;i<n;i++){
            //00 11 22
            //00 11 22 33 44 55 66
            answer[i][i]=1;
        }
        return answer;
    }
}