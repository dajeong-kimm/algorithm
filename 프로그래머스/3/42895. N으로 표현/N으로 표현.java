import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        Set<Integer> dp[] = new HashSet[9];
        for (int i=0;i<=8;i++){
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(N);
        
        for (int i=2;i<=8;i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<i;j++){
                sb.append(N);
            }
            dp[i].add(Integer.parseInt(sb.toString()));
            
            for (int j=1;j<i;j++){
                int k = i - j;
                for (int num1 : dp[j]){
                    for (int num2 : dp[k]){
                        dp[i].add(num1+num2);
                        dp[i].add(num1-num2);
                        dp[i].add(num1*num2);
                        if (num2 != 0) {
                            dp[i].add(num1/num2);
                        }
                    }
                }
            }
            
            //number가 가능한 숫자들 중에 포함되는지
            if (dp[i].contains(number)) return i;
        }
        return -1;
    }
}