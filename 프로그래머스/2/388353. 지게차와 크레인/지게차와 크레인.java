import java.util.*;
class Solution {
    static int n, m;
    static char[][] arr;
    static boolean[][] opened;
    static int removed = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        
        arr = new char[n+2][m+2];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                arr[i][j] = storage[i-1].charAt(j-1);
            }
        }
        opened = new boolean[n+2][m+2];
        for (int i=0;i<m;i++){
            opened[0][i] = true;
            opened[n+1][i] = true;
        }
        for (int i=1;i<=n;i++){
            opened[i][0] = true;
            opened[i][m+1] = true;
        }
        
        
        for (int i=0;i<requests.length;i++) {
            String cur = requests[i];
            if (cur.length() == 1) {
                forklift(cur);
            } else {
                crane(cur);
            }
        }
        
        return n*m - removed;
    }
    
    static void forklift(String str) {
        System.out.println("forklift");
        char ch = str.charAt(0);
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> removeQ = new ArrayDeque<>();
        boolean[][] visited = new boolean[n+2][m+2];
        
        for (int i=0;i<=n+1;i++){
            for (int j=0;j<=m+1;j++){
                if (i==0 || i==n+1 || j==0 || j==m+1) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx > n+1 || ny<0 || ny>m+1) continue;
                if (visited[nx][ny]) continue;
                
                if (opened[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                } else {
                    if (arr[nx][ny] == ch) {
                        removeQ.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        while (!removeQ.isEmpty()) {
            int[] cur = removeQ.poll();
            opened[cur[0]][cur[1]] = true;
            removed++;
        }
    }
    
    static void crane(String str) {
        System.out.println("crane");
        char ch = str.charAt(0);
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if (arr[i][j] == ch && !opened[i][j]) {
                    System.out.println(ch+": "+i+" "+j);
                    opened[i][j] = true;
                    removed++;
                }
            }
        }
    }
}