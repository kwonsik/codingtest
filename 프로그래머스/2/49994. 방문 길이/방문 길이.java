import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<>();
int x = 0;
int y = 0;

for (char c : dirs.toCharArray()) {
    int nx = x;
    int ny = y;

    // 1. 다음 이동할 좌표 계산
    if (c == 'U') ny++;
    else if (c == 'D') ny--;
    else if (c == 'R') nx++;
    else if (c == 'L') nx--;

    // 2. 경계를 벗어나면 무시! (이동하지 않음)
    if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

    // 3. 현재 좌표(x, y)에서 다음 좌표(nx, ny)로 가는 경로를 문자열로 만듭니다.
    String path1 = x + "," + y + "->" + nx + "," + ny; // 정방향
    String path2 = nx + "," + ny + "->" + x + "," + y; // 역방향

    // 4. Set에 양방향 경로를 모두 때려 넣습니다! (중복은 알아서 날아감)
    set.add(path1);
    set.add(path2);

    // 5. 캐릭터의 현재 위치를 다음 위치로 업데이트!
    x = nx;
    y = ny;
}
        
        return set.size()/2;
    }
}