class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int a = Math.max(sizes[0][0],sizes[0][1]);
        int b = Math.min(sizes[0][0],sizes[0][1]);
        for (int i=1;i<sizes.length;i++){
            a = Math.max(a,Math.max(sizes[i][0],sizes[i][1]));
            b = Math.max(b,Math.min(sizes[i][0],sizes[i][1]));
        }
        return a*b;
    }
}