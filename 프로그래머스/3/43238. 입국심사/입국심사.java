class Solution {
    static long MAX = 1_000_000_000;
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 1;
        long end = MAX * MAX;
        
        while (start <= end) {
            long mid = (start+end)/2;
            
            if (test(mid, times) >= n) {
                answer = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return answer;
    }
    
    static long test(long mid, int[] times) {
        long cnt = 0;
        for (int i=0;i<times.length;i++) {
            cnt += mid / times[i];
        }
        return cnt;
    }
}