class Solution {
    public int solution(int n) {
        int answer = 0;
        int max = 0;
        int q = 0;
        StringBuilder sb = new StringBuilder();
        while(Math.pow(3, max) <= n) {
            max++;
        }
        for(int i=max-1; i>=0; i--) {
            q = n / (int)Math.pow(3, i);
            sb.append(String.valueOf(q));
            n -= (int)Math.pow(3, i) * q;
        }
        String str = sb.toString();
        String arr[] = str.split("");
        
        for(int i=0; i<sb.length(); i++) {
            answer += Integer.parseInt(arr[i]) * (int)Math.pow(3, i); 
        }
        return answer;
    }
}