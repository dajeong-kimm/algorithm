import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        String num = Integer.toBinaryString(n);
        for (int i=0;i<num.length();i++){
            char c = num.charAt(i);
            if (c=='1') ans += 1;
        }

        return ans;
    }
}