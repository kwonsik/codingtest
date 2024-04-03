class Solution {
    public String[] solution(String myStr) {
        
        myStr=myStr.replaceAll("a"," ");
        myStr=myStr.replaceAll("b"," ");
        myStr=myStr.replaceAll("c"," ");
        String str[]=myStr.split(" ");
        int cnt=0;
        for(int i=0;i<str.length;i++){
            if(!str[i].equals("")){cnt++;}
        }
        String[] answer = new String[cnt];
        cnt=0;
        for(int i=0;i<str.length;i++){
            if(!str[i].equals("")){answer[cnt]=str[i];cnt++;}
        }
        if(cnt==0){answer=new String[1];answer[0]="EMPTY";}
        
        return answer;
    }
}