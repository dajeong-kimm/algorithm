import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Set<String>> map = new HashMap<>();
        for (int i=0;i<clothes.length;i++) {
            String name = clothes[i][0];
            String type = clothes[i][1];
            if (!map.containsKey(type)) {
                map.put(type, new HashSet<>());
            }
            map.get(type).add(name);
        }
        
        for (String type : map.keySet()) {
            answer *= (map.get(type).size()+1);
        }
        
        return answer-1;
    }
}