import java.util.*;
class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] Land;
    static int[][] landNum;
    static int n, m;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        
        Land = land;
        
        landNum = new int[n][m];
        int num = 1;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (land[i][j] == 1 && landNum[i][j] == 0) {
                    bfs(i, j, num++);
                }
            }
        }
        
        int[] landCnt = new int[num];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (landNum[i][j] > 0) {
                    landCnt[landNum[i][j]]++;
                }
            }
        }
        
        int maxValue = 0;
        for (int i=1;i<num;i++){
            maxValue += landCnt[i];
        }
        
        for (int j=0;j<m;j++){
            Set<Integer> set = new HashSet<>();
            int cur = 0;
            for (int i=0;i<n;i++){
                if (landNum[i][j] > 0) {
                    set.add(landNum[i][j]);
                }
            }
            for (int number : set) {
                cur += landCnt[number];
            }
            answer = Math.max(answer, cur);
            if (answer == maxValue) break;
        }
        return answer;
    }
    
    static void bfs(int x, int y, int num) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        landNum[x][y] = num;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx<0 || nx>=n || ny<0 || ny>=m) continue;
                
                if (Land[nx][ny] == 1 && landNum[nx][ny] == 0) {
                    landNum[nx][ny] = num;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}