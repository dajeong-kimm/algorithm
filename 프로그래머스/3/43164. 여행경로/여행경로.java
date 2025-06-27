import java.util.*;
class Solution {
    static Map<String, Integer> map;
    static int N;
    static boolean[] visited;
    static List<Info> pqArr[];
    static class Info implements Comparable<Info>{
        String toName;
        int id;
        
        Info(String toName, int id) {
            this.toName = toName;
            this.id = id;
        }
        
        @Override
        public int compareTo(Info o) {
            return toName.compareTo(o.toName);
        }
    }
    public String[] solution(String[][] tickets) {
        Stack<String> stack = new Stack<>();
        map = new HashMap<>();
        int idx = 0;
        N = tickets.length;
        visited = new boolean[N];
        
        pqArr = new ArrayList[10000];
        for (int i=0;i<10000;i++) {
            pqArr[i] = new ArrayList<>();
        }
        
        for (int i=0;i<N;i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            if (!map.containsKey(from)) {
                map.put(from, idx++);
            }
            if (!map.containsKey(to)) {
                map.put(to, idx++);
            }
            
            int id = map.get(from);
            pqArr[id].add(new Info(to, i));
        }
        
        for (int i=0;i<idx;i++) {
            Collections.sort(pqArr[i]);
        }
        
        dfs(stack, "ICN", 0);
        
        String[] answer = new String[stack.size()];
        idx = stack.size()-1;
        while (!stack.isEmpty()) {
            answer[idx--] = stack.pop();
        }
        
        return answer;
    }
    
    static boolean dfs(Stack<String> stack, String cur, int cnt) {
        stack.add(cur);
        
        if (cnt == N) return true;
        
        int id = map.get(cur);
        
        for (Info next : pqArr[id]) {
            if (!visited[next.id]) {
                visited[next.id] = true;
                if (dfs(stack, next.toName, cnt+1)) {
                    return true;
                }
                stack.pop();
                visited[next.id] = false;
            }
        }
        return false;
    }
}