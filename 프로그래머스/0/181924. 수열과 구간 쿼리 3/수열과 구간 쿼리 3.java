class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        for (int i=0;i<queries.length;i++){
            int number = queries[i][0];
            int number2 = queries[i][1];
            int tmp = arr[number];
            arr[number] = arr[number2];
            arr[number2] = tmp;
        }
        return arr;
    }
}