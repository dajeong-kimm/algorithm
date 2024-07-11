class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        
        for (long idx=left;idx<=right;idx++){
            int i = (int)(idx/n);
            int j = (int)(idx%n);
            
            answer[(int)(idx-left)] = Math.max(i,j)+1;
        }
        
        return answer;
    }
}