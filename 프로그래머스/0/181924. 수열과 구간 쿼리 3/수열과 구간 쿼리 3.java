class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        for(int i=0;i<queries.length;i++){
            int num=arr[queries[i][0]];
            arr[queries[i][0]]=arr[queries[i][1]];
            arr[queries[i][1]]=num;
        }
        answer=arr;
        return answer;
    }
}