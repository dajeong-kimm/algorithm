import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<N;i++) {
            set.add(nums[i]);
        }
        
        if (set.size() >= N/2) return N/2;
        return set.size();
    }
}