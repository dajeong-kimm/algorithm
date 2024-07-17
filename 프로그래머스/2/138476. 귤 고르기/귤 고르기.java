import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        ArrayList<Integer> sortedCounts = new ArrayList<>(map.values());
        sortedCounts.sort(Collections.reverseOrder());

        int numTypes = 0;
        int countSum = 0;

        for (int count : sortedCounts){
            countSum += count;
            numTypes++;

            if (countSum>=k) break;
        }

        return numTypes;
    }
}