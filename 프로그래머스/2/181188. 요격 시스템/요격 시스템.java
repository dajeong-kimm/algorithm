import java.util.*;
class Solution {
    static class Range implements Comparable<Range> {
        int start, end;
        
        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Range o) {
            return Integer.compare(end, o.end);
        }
    }
    public int solution(int[][] targets) {
        int answer = 0;
        int n = targets.length;
        Range[] range = new Range[n];
        
        for (int i=0;i<n;i++){
            range[i] = new Range(targets[i][0], targets[i][1]);
        }
        
        Arrays.sort(range);
        
        int before = -1;
        for (int i=0;i<n;i++){
            if (before >= range[i].start) { //요격 가능
                
            } else { //요격 불가능
                before = range[i].end-1;
                answer++;

            }
        }
        
        return answer;
    }
}