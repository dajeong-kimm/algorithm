import java.util.*;
/**
-1 +1 -10 +10 -100 +100 등 
층+버튼 < 0 : 움직이지 않음
0층이 가장 아래층

버튼 한번에 마법의 돌 한 개
어떤층에서 0층까지 내려가는데 필요한 최소 마법의 돌 개수
*/
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0){
            int remainder = storey%10;
            int next = storey/10;
            
            if (remainder == 5){
                if ((next%10) >= 5){
                    answer += (10 - remainder);
                    storey = next+1;
                } else {
                    answer += remainder;
                    storey = next;
                }
            } else if (remainder > 5){
                answer += (10 - remainder);
                storey = next + 1;
            } else {
                answer += remainder;
                storey = next;
            }
        }
        
        return answer;
    }
}