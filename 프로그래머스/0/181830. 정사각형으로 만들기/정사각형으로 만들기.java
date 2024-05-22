class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        int ans_size = Math.max(arr.length,arr[0].length);
        answer = new int[ans_size][ans_size];
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }
}