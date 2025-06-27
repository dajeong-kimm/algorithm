import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = operations.length;
        for (int i=0;i<n;i++) {
            String[] op = operations[i].split(" ");
            
            if (op[0].equals("I")) {
                int num = Integer.parseInt(op[1]);
                minPQ.add(num);
                maxPQ.add(num);
            } else {
                int num = Integer.parseInt(op[1]);
                if (num > 0) {
                    if (maxPQ.isEmpty()) continue;
                    int max = maxPQ.poll();
                    minPQ.remove(max);
                } else {
                    if (minPQ.isEmpty()) continue;
                    int min = minPQ.poll();
                    maxPQ.remove(min);
                }
            }
        }
        
        if (maxPQ.size() == 0) {
            return new int[]{0,0};
        }
        
        return new int[]{maxPQ.poll(), minPQ.poll()};
    }
}