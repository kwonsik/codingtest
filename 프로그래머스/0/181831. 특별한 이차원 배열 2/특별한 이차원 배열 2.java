class Solution {
    public int solution(int[][] arr) {
        int answer = 0;
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==arr[j][i]){cnt++;}
            }
        }
        if(cnt==arr.length*arr[0].length){answer=1;}
        return answer;
    }
}