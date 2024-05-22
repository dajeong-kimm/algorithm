class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            int tmp = 1000001;
            
            for (int i=s;i<=e;i++) {
                if (arr[i]>k) tmp = Math.min(tmp,arr[i]);
            }
            if (tmp == 1000001) answer[idx++] = -1;
            else answer[idx++] = tmp;
            
        }
        return answer;
    }
}