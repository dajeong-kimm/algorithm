import java.util.*;
class Solution {
    static int N, len;
    static boolean flag = false;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        N = words.length;
        len = begin.length();
        
        boolean[] visited = new boolean[N];
        Queue<String> q = new ArrayDeque<>();
        q.add(begin);
        
        while (!q.isEmpty()) {
            int qSize = q.size();
            
            for (int cnt=0;cnt<qSize;cnt++) {
                String cur = q.poll();
                
                if (cur.equals(target)) {
                    flag = true;
                    return answer;
                }
                for (int i=0;i<N;i++) {
                    if (!visited[i] && testDiff(cur, words[i])) {
                        visited[i] = true;
                        q.add(words[i]);
                    }
                }
            }
            
            answer++;
        }
        
        return 0;
    }
    
    static boolean testDiff(String begin, String target) {
        int cnt = 0;
        for (int i=0;i<len;i++) {
            if (begin.charAt(i) != target.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        return cnt == 1;
    }
}