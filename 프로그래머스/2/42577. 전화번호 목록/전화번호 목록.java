import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        Set<String> set = new HashSet<>();
        int N = phone_book.length;
        for (int i=0;i<N;i++) {
            String cur = phone_book[i];
            for (int j=1;j<cur.length();j++) {
                String tmp = cur.substring(0,j);
                if (set.contains(tmp)) return false;
            }
            set.add(cur);
        }
        return true;
    }
}