import java.util.*;
class Solution {
    static class Work implements Comparable<Work> {
        int workingTime;
        int offerTime;
        int num;
        
        Work(int workingTime, int offerTime, int num) {
            this.workingTime = workingTime;
            this.offerTime = offerTime;
            this.num = num;
        }
        
        @Override
        public int compareTo(Work o) {
            if (workingTime == o.workingTime) {
                if (offerTime == o.offerTime) {
                    return Integer.compare(num, o.num);
                }
                return Integer.compare(offerTime, o.offerTime);
            }
            return Integer.compare(workingTime, o.workingTime);
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<Work> pq = new PriorityQueue<>();
        pq.add(new Work(jobs[0][1], jobs[0][0], 0));
        int time = jobs[0][0];
        int n = jobs.length;
        int idx = 1;
        
        
        
        while (idx < n) {
            while (jobs[idx][0] <= time) {
                pq.add(new Work(jobs[idx][1], jobs[idx][0], idx));
                idx++;
                if (idx >= n) break;
            }
            
            if (pq.isEmpty()) time++;
            
            else {
                Work cur = pq.poll();
                time += cur.workingTime;
                answer += (time-cur.offerTime);
            }
        }
        
        while (!pq.isEmpty()) {
            Work cur = pq.poll();
            time += cur.workingTime;
            answer += (time-cur.offerTime);
        }
        
        return answer/n;
    }
}