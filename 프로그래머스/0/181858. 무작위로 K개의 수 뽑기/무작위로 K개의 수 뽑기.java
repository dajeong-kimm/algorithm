import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int a : arr) {
            if (!list.contains(a)) list.add(a);
        }
        int[] answer = new int[k];
        for (int i=0;i<answer.length;i++){
            answer[i] = -1;
        }
        for (int i=0;i<Math.min(answer.length,list.size());i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}