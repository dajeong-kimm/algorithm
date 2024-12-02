import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int answer;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static int arrayMAX, arrayMIN;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        arrayMAX = Integer.MIN_VALUE;
        arrayMIN = Integer.MAX_VALUE;
        
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arrayMAX = Math.max(arrayMAX, arr[i][j]);
                arrayMIN = Math.min(arrayMIN, arr[i][j]);
            }
        }
        
        int start = 0;
        int end = arrayMAX - arrayMIN;
        
        answer = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            boolean flag = false;

            // 가능한 모든 시작 범위 [i, i + mid]를 탐색
            for (int i = arrayMIN; i <= arrayMAX - mid; i++) {
                // 시작점이 현재 범위 내에 있는지 확인
                if (i <= arr[0][0] && arr[0][0] <= i + mid) {
                    if (bfs(i, i + mid)) {
                        flag = true;
                        break;
                    }
                }
            }
            
            if (flag) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
    
    // [minVal, maxVal] 범위 내에서 경로가 존재하는지 확인하는 BFS 함수
    static boolean bfs(int minVal, int maxVal) {
        // 시작점이 범위 내에 있는지 확인
        if (arr[0][0] < minVal || arr[0][0] > maxVal) return false;
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            // 도착점에 도달했는지 확인
            if (x == n - 1 && y == n - 1) return true;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                // 다음 셀이 범위 내에 있고, 방문하지 않았다면 큐에 추가
                if (!visited[nx][ny] && arr[nx][ny] >= minVal && arr[nx][ny] <= maxVal) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        
        return false;
    }
}