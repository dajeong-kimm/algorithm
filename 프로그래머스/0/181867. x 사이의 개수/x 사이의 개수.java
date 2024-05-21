import java.util.*;
class Solution {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
        String[] tmp = myString.split("x");
        for (int i=0;i<tmp.length;i++){
            list.add(tmp[i].length());
        }
        if (myString.endsWith("x")) list.add(0);
        int[] answer = new int[list.size()];
        for (int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}