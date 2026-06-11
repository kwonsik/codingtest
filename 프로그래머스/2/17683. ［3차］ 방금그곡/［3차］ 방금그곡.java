import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1; // 가장 긴 재생 시간을 기록할 단일 변수
        
        m = replaceMelody(m);
        
        for (String info : musicinfos) {
            String[] split = info.split(",");
            int playTime = calTime(split[1]) - calTime(split[0]);
            String title = split[2];
            
            String sound = replaceMelody(split[3]);
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                sb.append(sound.charAt(i % sound.length()));
            }
            String allSound = sb.toString();
            
            if (allSound.contains(m)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        
        return answer;
    }
    
    private String replaceMelody(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }
    
    private int calTime(String timeStr) {
        String[] split = timeStr.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}