class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[(int)Math.ceil((double)num_list.length/n)];
        System.out.print(answer.length);
        int cnt=0;
        for(int i=0;i<num_list.length;i++){
            if(i%n==0){answer[cnt]=num_list[i];cnt++;}
        }
        return answer;
    }
}