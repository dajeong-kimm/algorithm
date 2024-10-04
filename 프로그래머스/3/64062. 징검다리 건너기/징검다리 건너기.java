class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int min = 1;
        int max = Integer.MAX_VALUE;
        
        //이분탐색 기준 : 징검다리를 건널 수 있는 친구의 수
        while (min <= max){
            int mid = (min+max)/2;
            
            if (isPass(stones, k, mid)){
                min = mid+1;
                answer = Math.max(answer,mid);
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
    
    boolean isPass(int[] stones, int k, int f){
        int skip = 0; //못 건너는 징검다리 개수 저장
        
        for (int stone : stones){
            if (stone - f < 0){
                skip++;
            } else {
                skip = 0;
            }
            
            if (skip == k) return false;
        }
        return true;
    }
}