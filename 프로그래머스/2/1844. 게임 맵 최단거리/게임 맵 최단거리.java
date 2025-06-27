import java.util.*;
class Solution {
    static int n, m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(int[][] maps) {

        n = maps.length;
        m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.add(new int[]{0,0,1});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == n-1 && cur[1] == m-1) {
                return cur[2];
            }
            
            for (int i=0;i<4;i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx<0 || nx>=n || ny<0 || ny>=m ) continue;
                
                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        
        return -1;
    }
}