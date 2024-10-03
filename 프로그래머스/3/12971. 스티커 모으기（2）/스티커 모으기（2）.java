import java.util.*;
//스티커를 뜯어내어 얻을 수 있는 숫자의 합의 최댓값 return
class Solution {
    public int solution(int sticker[]) {
        int N = sticker.length;
        
        if (N == 1){
            return sticker[0];
        }
        
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        
        
        
        //첫번째 스티커 떼었을 때
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for (int i=2;i<N-1;i++){
            dp1[i] = Math.max(dp1[i-2]+sticker[i], dp1[i-1]);
        }
        
        
        //첫번째 스티커를 떼지 않았을 때
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i=2;i<N;i++){
            dp2[i] = Math.max(dp2[i-2]+sticker[i], dp2[i-1]);
        }
       
        int answer = Math.max(dp1[N-2], dp2[N-1]);

        return answer;
    }
}