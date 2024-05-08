class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int size = 0;
        for (int i=0;i<intervals.length;i++){
            size += intervals[i][1]-intervals[i][0]+1;
        }
        int[] answer = new int[size];
        int tmp = 0;
        int idx = 0;
        for (int i=0;i<intervals.length;i++){
            tmp = intervals[i][0];
            for (int j=tmp;j<=intervals[i][1];j++){
                answer[idx++] = arr[j];
            }
        }
        return answer;
    }
}