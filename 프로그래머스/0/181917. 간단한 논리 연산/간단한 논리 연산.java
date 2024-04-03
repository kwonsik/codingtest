class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
        boolean result1;
        boolean result2;
        boolean result3;
        if(x1==false&&x2==false){result1=false;}
        else{result1=true;}
        if(x3==false&&x4==false){result2=false;}
        else{result2=true;}
        if(result1==true&&result2==true){answer=true;}
        else{answer=false;}
        return answer;
    }
}