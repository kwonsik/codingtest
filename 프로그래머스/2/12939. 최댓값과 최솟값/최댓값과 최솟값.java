class Solution {
    public String solution(String s) {
        String answer = "";
        
        String split[] = s.split(" ");
        int min = Integer.parseInt(split[0]);
        int max = Integer.parseInt(split[0]);
        for(String str : split) {
            int i = Integer.parseInt(str);
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        answer = min + " " + max;
        return answer;
    }
}