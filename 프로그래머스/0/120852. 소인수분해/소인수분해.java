import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        LinkedHashSet<Integer> prime = new LinkedHashSet<Integer>();
        int i = 2;
        while (n != 0 && i<=n){
            if (n%i == 0){
                prime.add(i);
                n /= i;
            } else {
                i += 1;
            }
        }
        return prime.stream().mapToInt(Integer::intValue).toArray();
    }
}