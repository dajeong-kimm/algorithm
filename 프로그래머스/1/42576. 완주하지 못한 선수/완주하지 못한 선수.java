import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        int N = participant.length;
        for (int i=0;i<N;i++) {
            String name = participant[i];
            if (!map.containsKey(name)) {
                map.put(name, 0);
            }
            map.put(name, map.get(name)+1);
        }
        
        for (int i=0;i<N-1;i++) {
            String name = completion[i];
            map.put(name, map.get(name)-1);
        }
        
        for (String name : map.keySet()) {
            if (map.get(name) > 0) return name;
        }

        return answer;
    }
}