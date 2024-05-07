class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int sum = 0;
        for (int n: arr){
            sum += n;
        }
        answer = new int[sum];
        int idx = 0;
        
        for(int n:arr){
            for(int i=0;i<n;i++){
                answer[idx++] = n;
            }
        }
        return answer;
    }
}