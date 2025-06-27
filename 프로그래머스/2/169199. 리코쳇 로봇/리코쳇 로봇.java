import java.util.*;
class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int answer;
    static char[][] arr;
    static int N,M;
    static int startX, startY, endX, endY;
    public int solution(String[] board) {
        answer = -1;
        N = board.length;
        M = board[0].length();
        arr = new char[N][M];
        
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                char ch = board[i].charAt(j);
                arr[i][j] = ch;
                if (ch == 'R') {
                    startX = i;
                    startY = j;
                    arr[i][j] = '.';
                } else if (ch == 'G') {
                    endX = i;
                    endY = j;
                    arr[i][j] = '.';
                }
            }
        }
        // System.out.println(startX+" "+startY);
        // System.out.println(endX+" "+endY);
        visited = new boolean[N][M];
        bfs();
        return answer;
    }
    
    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited[startX][startY] = true;
        q.add(new int[]{startX, startY, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            // System.out.println("cur: "+cur[0]+" "+cur[1]);
            
            if (cur[0] == endX && cur[1] == endY) {
                answer = cur[2];
                return;
            }
            
            for (int i=0;i<4;i++) {
                int nx = cur[0];
                int ny = cur[1];
                
                while (true) { //장애물 만나기 전까지 이동
                    int nxx = nx + dx[i];
                    int nyy = ny + dy[i];
                    
                    if (nxx < 0 || nxx >=  N || nyy < 0 || nyy >= M) break;
                    if (arr[nxx][nyy] == 'D') break;
                    
                    nx = nxx;
                    ny = nyy;
                }
                
                if (nx == cur[0] && ny == cur[1]) continue;
                // System.out.println("   nxny: "+nx+" "+ny);
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,cur[2]+1});
                }
                
            }
        }
    }
}