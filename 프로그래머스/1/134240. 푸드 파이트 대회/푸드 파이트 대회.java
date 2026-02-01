class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=1; i<food.length; i++) {
            cnt = food[i] / 2;
            for(int j=0; j<cnt; j++) {
                sb.append(i);
            }
        }
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        answer = str1 + "0" + str2;
        return answer;
    }
}