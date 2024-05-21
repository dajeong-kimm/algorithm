class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] count = new int[31];
        for (String str : strArr){
            count[str.length()] += 1;
        }
        for (int i=0;i<31;i++){
            if (answer<count[i]) answer = count[i];
        }
        return answer;
    }
}