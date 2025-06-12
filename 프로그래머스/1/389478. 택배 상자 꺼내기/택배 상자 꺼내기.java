class Solution {
    public int solution(int n, int w, int num) {
        int[][] arr = new int[n/w+1][w];
        int number = 1;
        A: for (int i=0;i<n/w+1;i++){
            if (i%2 == 0){
                for (int j=0;j<w;j++){
                arr[i][j] = number++;
                if (number > n) break A;
                }
            } else {
                for (int j=w-1;j>=0;j--){
                    arr[i][j] = number++;
                    if (number > n) break A;
                }
            }
            
        }
        
        int answer = 0;
        for (int i=0;i<n/w+1;i++){
            for (int j=0;j<w;j++){
                if (arr[i][j] == num) {
                    for (int line=i;line<arr.length;line++){
                        if (arr[line][j] > 0) answer++;
                    }
                    return answer;
                }
            }
        }
        return -1;
    }
}