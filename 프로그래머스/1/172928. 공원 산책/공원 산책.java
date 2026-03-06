import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    x = j;
                    y = i;
                    break;
                }                
            }
        }
        for(int i=0; i<routes.length; i++) {
            char ch = routes[i].charAt(0);
            int cnt = (int)routes[i].charAt(2) - 48;
            boolean isX = false;
            
            if(ch == 'N') {
                if(y - cnt >= 0) {
                    for(int j=1; j<=cnt; j++) {
                        if(park[y-j].charAt(x) == 'X') {
                            isX = true;
                            break;
                        }
                    }   
                    if(!isX) {
                        y -= cnt;
                    }
                }    
            } else if(ch == 'E') {
                if(x + cnt <= park[0].length() - 1) {
                    for(int j=1; j<=cnt; j++) {
                        if(park[y].charAt(x+j) == 'X') {
                            isX = true;
                            break;
                        }
                    }   
                    if(!isX) {
                        x += cnt;
                    }
                }  
            } else if(ch == 'W') {
                if(x - cnt >= 0) {
                    for(int j=1; j<=cnt; j++) {
                        if(park[y].charAt(x-j) == 'X') {
                            isX = true;
                            break;
                        }
                    }   
                    if(!isX) {
                        x -= cnt;
                    }
                }
            } else if(ch == 'S') {
                if(y + cnt <= park.length - 1) {
                    for(int j=1; j<=cnt; j++) {
                        if(park[y+j].charAt(x) == 'X') {
                            isX = true;
                            break;
                        }
                    }   
                    if(!isX) {
                        y += cnt;
                    }
                }  
            }  
        }
        System.out.println("x : " + x + " / y : " + y);
        answer[0] = y;
        answer[1] = x;
        return answer;
    }
}