import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = arr;
        for(int i=0;i<arr.length;i++){
            if(arr.length%2==1&&i%2==0){answer[i]+=n;}
            else if(arr.length%2==0&&i%2==1){answer[i]+=n;}
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}