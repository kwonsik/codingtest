import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
  
        for(int i=0;i<intStrs.length;i++){
            String str="";
            for(int j=s;j<s+l;j++){
                str+=intStrs[i].charAt(j);
            }
            if(Integer.parseInt(str)>k){answer.add(Integer.parseInt(str));}
        }
        return answer;
    }
}