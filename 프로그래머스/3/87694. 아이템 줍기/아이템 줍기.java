import java.util.*;
class Solution {
    static int[][] map = new int[101][101];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited = new boolean[101][101];
    static int result = 0;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        drawMap(rectangle);
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return result;
    }
    
    static void drawMap(int[][] rectangle) {
        for (int[] rect : rectangle) {
            int startX = rect[1] * 2;
            int endX = rect[3] * 2;
            
            int startY = rect[0] * 2;
            int endY = rect[2] * 2;
            
            for (int i=startX;i<=endX;i++) {
                for (int j=startY;j<=endY;j++) {
                    if (i == startX || i == endX || j == startY || j == endY) {
                        if (map[i][j] == 2) {
                            continue;
                        }
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
    }
    
    static void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{characterY, characterX, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curStep = cur[2];
            
            if (curX == itemY && curY == itemX) {
                result = curStep/2;
                return;
            }
            
            for (int i=0;i<4;i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx<=0 || nx>100 || ny<=0 || ny>100) continue;
                
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,curStep+1});
                }
            }
        }
    }
}