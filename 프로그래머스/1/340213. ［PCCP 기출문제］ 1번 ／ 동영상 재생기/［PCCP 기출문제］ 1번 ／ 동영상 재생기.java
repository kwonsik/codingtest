class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String split[] = new String[2];        
        
        // 영상 길이
        split = video_len.split(":");
        int video_length = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]); 
        // 시작 지점
        split = pos.split(":");
        int start = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]); 
        // 오프닝 시작 지점
        split = op_start.split(":");
        int opening_start = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
        // 오프닝 끝 지점
        split = op_end.split(":");
        int opening_end = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
        
        for(int i=0; i<commands.length; i++) {
            // 오프닝 사이면
            if(start >= opening_start && start <= opening_end) {
                start = opening_end;
            }
            if("next".equals(commands[i])) {                
                start += 10;
                // 끝을 넘어가면
                if(start >= video_length) {
                    start = video_length;
                }
            } else if("prev".equals(commands[i])) {
                start -= 10;
                // 시작을 넘어가면
                if(start <= 0) {
                    start = 0;
                }
            }
            // 오프닝 사이면
            if(start >= opening_start && start <= opening_end) {
                start = opening_end;
            }
        }
        String min = String.valueOf(start/60);
        if(min.length() == 1) {
            min = "0" + min;
        }
        String sec = String.valueOf(start%60);
        if(sec.length() == 1) {
            sec = "0" + sec;
        }
        answer = min + ":" + sec;
        return answer;
    }
}