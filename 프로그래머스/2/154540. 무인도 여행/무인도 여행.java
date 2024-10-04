import java.util.*;
/**
X 바다
1~9 무인도
flood fill : 상하좌우로 연결되는 땅들은 하나의 무인도 
지도의 각 칸에 적힌 숫자 : 식량 : 적힌 숫자를 모두 합한 값 : 최대 며칠동안 머물 수 있는지
지낼 수 있는 무인도가 없다면 -1
*/
class Solution {
    int[][] map;
    int N,M;
    List<Integer> list = new ArrayList<>();
    boolean[][] visited;
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        map = new int[N][M];
        for (int i=0;i<N;i++){
            String tmp = maps[i];
            for (int j=0;j<M;j++){
                char ch = tmp.charAt(j);
                if (ch != 'X'){
                    map[i][j] = ch-'0';
                }
            }
        }
        
        visited = new boolean[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (map[i][j] > 0 && !visited[i][j]) {
                    int cnt = bfs(i,j);
                    list.add(cnt);
                }
            }
        }
        
        if (list.size() == 0) return new int[]{-1};
        
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for (int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    int bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        
        int result = map[x][y];
        while (!queue.isEmpty()){
            int cur[] = queue.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            
            for (int i=0;i<4;i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                
                if (nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny]>0){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    result += map[nx][ny];
                }
            }
        }
        return result;
    }
}