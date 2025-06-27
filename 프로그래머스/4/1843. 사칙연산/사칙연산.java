class Solution {
    static int numbers[];
    static String operations[];
    static int dp[][][];
    public int solution(String arr[]) {
        int n = arr.length / 2;
        
        dp = new int[2][200][200];
        for (int i=0;i<n+1;i++) {
            for (int j=0;j<n+1;j++) {
                dp[0][i][j] = Integer.MIN_VALUE; //최댓값
                dp[1][i][j] = Integer.MAX_VALUE; //최솟값
            }
        }
        
        numbers = new int[n+1];
        operations = new String[n];
        
        for (int i=0;i<arr.length;i++) {
            if (i%2 == 0) {
                numbers[i/2] = Integer.parseInt(arr[i]); 
            } else {
                operations[i/2] = arr[i];
            }
        }
        
        return calc(0, 0, n);
    }
    
    static int calc(int flag, int start, int end) {
        if (start == end) {
            dp[flag][start][end] = numbers[start];
            return dp[flag][start][end];
        }
        
        if (visited(flag, start, end)) {
            return dp[flag][start][end];
        }
        
        dp[flag][start][end] = 0;
        
        int result = flag == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        if (flag == 0) {
            for (int mid = start ; mid < end; mid++) {
                if (operations[mid].equals("-")) {
                    //max - min
                    result = Math.max(result, calc(0, start, mid) - calc(1, mid+1, end));
                    continue;
                }
                result = Math.max(result, calc(0, start, mid) + calc(0, mid+1,end));
            }
        } 
        
        if (flag == 1) {
            for (int mid = start ; mid < end; mid++) {
                if (operations[mid].equals("-")) {
                    result = Math.min(result, calc(1, start, mid) - calc(0, mid+1, end));
                    continue;
                }
                result = Math.min(result, calc(1, start, mid) + calc(1, mid+1, end));
            }
        }
        
        dp[flag][start][end] = result;
        return dp[flag][start][end];
    }
    
    static boolean visited(int flag, int start, int end) {
        //현재값과 초기값이 동일하지 않으면 방문
        return dp[flag][start][end] != Integer.MIN_VALUE && dp[flag][start][end] != Integer.MAX_VALUE;
    }
}