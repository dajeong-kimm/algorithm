import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> al = new ArrayList<>();
        
        for (String str:strArr){
            if (!str.contains("ad")){
                al.add(str);
            }
        }
        return al.toArray(String[]::new);
    }
}