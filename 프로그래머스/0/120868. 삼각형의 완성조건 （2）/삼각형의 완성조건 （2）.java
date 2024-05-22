import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        for (int i=1;i<=sides[0]+sides[1];i++){
            int[] new_sides = new int[]{sides[0],sides[1],i};
            Arrays.sort(new_sides);
            if (new_sides[2]<new_sides[0]+new_sides[1]) answer += 1;
            
        }
        return answer;
    }
}