import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i=0; i<record.length; i++) {
            String split[] = record[i].split(" ");
            String type = split[0];
            String uuid = split[1];
            if(split.length > 2) {
                String name = split[2];
                map.put(uuid, name);
            }           
        }
        for(int i=0; i<record.length; i++) {
            String split[] = record[i].split(" ");
            String type = split[0];
            String uuid = split[1];
            String name = map.get(uuid);
            if("Change".equals(type)) {
                continue;
            } else {
                String msg = "";
                if("Enter".equals(type)) {
                    msg = name + "님이 들어왔습니다.";
                } else {
                    msg = name + "님이 나갔습니다.";
                }
                list.add(msg);
            }
        }
        answer = list.toArray(new String[list.size()]);
        return answer;
    }
}