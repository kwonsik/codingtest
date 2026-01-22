class Solution {
    public long solution(long n) {
        
        int arr[] = new int[10];
        String str = String.valueOf(n);

        for(int i=0; i<str.length(); i++) {

            int temp = str.charAt(i) - '0';
            arr[temp]++;
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i=9; i>=0; i--) {
            for(int j=0; j<arr[i]; j++) {
                sb.append(i);
            }
        }

        return Long.parseLong(sb.toString());
    }
}