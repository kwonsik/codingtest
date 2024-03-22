class Solution {
    public int solution(String num_str) {
        int answer = 0;
        String arr[]=new String[num_str.length()];
        
        for(int i=0;i<num_str.length();i++){
            arr[i]=String.valueOf(num_str.charAt(i));
            answer+=Integer.parseInt(arr[i]);
        }
        return answer;
    }
}