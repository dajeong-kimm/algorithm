import java.util.*;
/**
탑승한 사람의 무게와 시소 축과 좌석간의 거리의 곱이 양쪽 다 같다면 시소 짝꿍
시소 짝꿍이 몇 쌍 존재하는지 ? 
*/
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for (int w : weights){
            double a = w*1.0;
            double b = w/2.0;
            double c = (w*2.0)/3.0;
            double d = (w*3.0)/4.0;
            
            if (map.containsKey(a)) answer += map.get(a);
            if (map.containsKey(b)) answer += map.get(b);
            if (map.containsKey(c)) answer += map.get(c);
            if (map.containsKey(d)) answer += map.get(d);
            
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a,1);
            }
        }
        return answer;
    }
}