import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                visited[i] = true;
                answer++;
                
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    
                    for (int j=0;j<n;j++) {
                        if (!visited[j] && computers[cur][j] == 1) {
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }
        return answer;
    }
}