class Solution {
    public long solution(long n) {
        long answer = 0;
        int arr[] = new int[10];
        String str = String.valueOf(n);
        int length = str.length();
        for(int i=0; i<length; i++) {
            int temp = str.charAt(i) - 48;
            arr[temp] += 1;
            
        }
        str = "";
        for(int i=9; i>=0; i--) {
            for(int j=0; j<arr[i]; j++) {
                if(arr[i] != 0) {
                    str += String.valueOf(i);
                }
            }        
        }
        answer = Long.parseLong(str);

        return answer;
    }
}