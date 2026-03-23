class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2[0].length; j++) {
                int sum = 0;
                for(int k=0; k<arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];               
                }
                answer[i][j] = sum;
            }
        }
        /*
        answer[0][0]
        arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[0][1]
        answer[0][1]
        arr1[0][0] * arr2[1][0] + arr1[0][1] * arr2[1][1]
        
        answer[1][0]
        arr1[1][0] * arr2[0][0] + arr1[1][1] * arr2[0][1]
        answer[1][1]
        arr1[1][0] * arr2[1][0] + arr1[1][1] * arr2[1][1]
        
        answer[2][0]
        arr1[2][0] * arr2[0][0] + arr1[2][1] * arr2[0][1]
        answer[2][1]
        arr1[2][0] * arr2[1][0] + arr1[2][1] * arr2[1][1]
        
        
        
        */
         
        return answer;
    }
}