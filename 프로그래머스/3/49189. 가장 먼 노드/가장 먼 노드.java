import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int m = edge.length;
        List<Integer> graph[] = new ArrayList[n+1];
        for (int i=0;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0;i<m;i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        
        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = 0;
        q.add(1);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (visited[next] == -1) {
                    visited[next] = visited[cur] + 1;
                    q.add(next);
                }
            }
        }
        
        int max = 0;
        for (int i=1;i<=n;i++) {
            max = Math.max(visited[i], max);
        }
        
        for (int i=0;i<=n;i++) {
            if (visited[i] == max) answer++;
        }
        
        
        return answer;
    }
}