class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int cnt=0;
        for(int i=0;i<myString.length()-pat.length()+1;i++){
            
             String str="";
            for(int j=cnt;j<pat.length()+cnt;j++){
               str+=myString.charAt(j);
               
            }
            System.out.println(str);
            if(str.equals(pat)){answer+=1;}
            cnt++;
        }
        return answer;
    }
}