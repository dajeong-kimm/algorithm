import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = -1;
        while (true) {
            int[] new_arr = Arrays.copyOf(arr,arr.length);
            for (int i=0;i<new_arr.length;i++){
                if (new_arr[i]>=50 && new_arr[i]%2 == 0){
                    new_arr[i] /= 2;
                }
                else if (new_arr[i] < 50 && new_arr[i]%2 == 1){
                    new_arr[i] = new_arr[i]*2 +1;
                }
            }
            answer += 1;
            if (Arrays.equals(new_arr,arr)) return answer;
            else arr = Arrays.copyOf(new_arr, new_arr.length);
        }
    }
}