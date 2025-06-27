import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int cnt = 0;
        boolean[] avail = new boolean[n+1];
        Arrays.sort(lost);
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<lost.length;i++) {
            set.add(lost[i]);
        }
        for (int i=0;i<reserve.length;i++) {
            avail[reserve[i]] = true;
        }
        
        for (int i=0;i<lost.length;i++) {
            int num = lost[i];
            
            if (avail[num]) {
                avail[num] = false;
                cnt++;
                continue;
            }
                             
            if (avail[num-1] && !set.contains(num-1)) {
                avail[num-1] = false;
                cnt++;
                continue;
            }
            if (num+1 <= n && avail[num+1] && !set.contains(num+1)) {
                avail[num+1] = false;
                cnt++;
            }
        }
        return n - lost.length + cnt;
    }
}