class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<phone_number.length(); i++) {
            if(phone_number.length() - i < 5) {
                sb.append(phone_number.charAt(i));
            } else {
                sb.append("*");
            }
        }
        answer = sb.toString();
        return answer;
    }
}