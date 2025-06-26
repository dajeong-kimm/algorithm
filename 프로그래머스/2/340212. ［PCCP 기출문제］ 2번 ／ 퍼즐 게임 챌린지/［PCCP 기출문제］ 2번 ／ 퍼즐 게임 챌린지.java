import java.util.*;
class Solution {
    static long Limit;
    static int n; //문제 갯수
    static int[] Diffs;
    static int[] Times;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        Diffs = diffs;
        Times = times;
        Limit = limit;
        n = diffs.length;
        
        int start = 1;
        int end = 1;
        for (int i=0;i<n;i++){
            end = Math.max(end, diffs[i]);
        }
        
        while (start <= end) {
            int mid = (start+end)/2;
            
            if (canSolve(mid)) {
                answer = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return answer;
    }
    
    static boolean canSolve(int level) {
        long time = 0;
        for (int i=0;i<n;i++){
            if (level >= Diffs[i]) {
                time += Times[i];
            } else {
                time += (Times[i]+Times[i-1]) * (Diffs[i] - level);
                time += Times[i]; 
            }
            if (time > Limit) return false;
        }
        return true;
    }
}