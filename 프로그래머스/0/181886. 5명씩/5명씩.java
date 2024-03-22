class Solution {
    public String[] solution(String[] names) {
        String[] answer = new String[(int)Math.ceil(names.length/5.0)];
        int cnt=0;
        for(int i=0;i<names.length;i++){
            if(i%5==0){answer[cnt]=names[i];cnt++;}
        }
        return answer;
    }
}