import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = scoville.length;
        for (int i=0;i<n;i++){
            pq.add(scoville[i]);
        }
        
        while (true) {
            if (pq.peek() >= K) break;
            if (pq.size() < 2) return -1;
            
            int a = pq.poll();
            int b = pq.poll();
            
            pq.add(a + b*2);
            answer++;
        }
        return answer;
    }
}