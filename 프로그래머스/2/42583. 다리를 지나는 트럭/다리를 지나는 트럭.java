import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> wait = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i=0;i<bridge_length;i++) {
            bridge.add(0);
        }
        int curWeight = 0;
        
        for (int i=0;i<truck_weights.length;i++) {
            wait.add(truck_weights[i]);
        }
        
        int cnt = 0;
        while (cnt < truck_weights.length) {
            answer++; // 1초증가
            boolean flag = false;
            //기존 트럭 내리기
            int truck = bridge.poll();
            if (truck > 0) cnt++;
            curWeight -= truck;
            
            if (!wait.isEmpty() && wait.peek()+curWeight <= weight) {
                int newTruck = wait.poll();
                curWeight += newTruck;
                bridge.add(newTruck);
                flag = true;
            }
            if (!flag) bridge.add(0);
        }
        return answer;
    }
}