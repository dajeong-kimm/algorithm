import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int n = progresses.length;
        for (int i=0;i<n;i++) {
            q.add((int) Math.ceil((100.0-progresses[i])/speeds[i]));
        }
        
        int time = 0;
        while (!q.isEmpty()) {
            if (time < q.peek()) {
                time = q.peek();
            }
            
            int cnt = 0;
            while (!q.isEmpty()) {
                if (q.peek() <= time) {
                    q.poll();
                    cnt++;
                } else break;
            }
            list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}