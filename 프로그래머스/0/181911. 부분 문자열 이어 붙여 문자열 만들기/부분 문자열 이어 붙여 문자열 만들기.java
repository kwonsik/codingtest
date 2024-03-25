class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        int num1=0;
        int num2=0;
        for(int i=0;i<parts.length;i++){
            num1=parts[i][0];
            num2=parts[i][1];
            for(int j=num1;j<=num2;j++){
                answer+=my_strings[i].charAt(j);
            }
            
        }
        return answer;
    }
}