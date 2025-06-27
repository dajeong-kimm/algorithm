import java.util.*;
class Solution {
    static class Work {
        int number;
        int priority;
        
        Work(int number, int priority) {
            this.number = number;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Work> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = priorities.length;
        for (int i=0;i<n;i++) {
            int p = priorities[i];
            q.add(new Work(i, p));
            pq.add(p);
        }
        
        int answer = 0;
        while (!q.isEmpty()) {
            Work cur = q.poll();
            
            if (cur.priority == pq.peek()) {
                answer++;
                if (cur.number == location) return answer;
                pq.poll();
            } else {
                q.add(cur);
            }
        }
        
        return -1;
    }
}