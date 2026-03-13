class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        // 배열 내의 모든 수의 최소 공배수를 구하면 되는데 1 3 4 7
        int min = 0;
        int max = 0;
        int result = 0;
        for(int i=0; i<arr.length; i++) {
            if(i != 0) {
                // 최대 공약수
                min = calc(arr[i-1], arr[i]);
                // 최소 공배수
                max = arr[i-1] * arr[i] / min;
                arr[i] = max;
            }
        }
        answer = max;
        return answer;
    }
    
    // 최대 공약수
    public int calc(int a, int b) {
        int result = 1;
        for(int i=1; i<=a; i++) {
            if(b % i == 0 && a % i==0) {
                result=i;
            }
        }
        return result;
    }
}