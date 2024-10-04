import java.util.*;
class Solution {
    int[][] arr;
    int N,M;
    List<Integer> answer = new ArrayList<>();
    public int[] solution(int rows, int columns, int[][] queries) {
        N = rows;
        M = columns;
        int num = 1;
        arr = new int[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                arr[i][j] = num++;
            }
        }
        
        for (int i=0;i<queries.length;i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            
            arr = turn(x1-1,y1-1,x2-1,y2-1);
        }
        
        int[] ansArr = new int[answer.size()];
        for (int i=0;i<answer.size();i++){
            ansArr[i] = answer.get(i);
        }
        return ansArr;
    }
    int[][] turn(int a, int b, int c, int d){
        int[][] result = copy(arr);
        List<Integer> list = new ArrayList<>();
        //가로줄(상단)
        for (int i=b+1;i<=d;i++){
            result[a][i] = arr[a][i-1];
            list.add(arr[a][i-1]);
        }
        
        //세로줄(우측)
        for (int i=a+1;i<=c;i++){
            result[i][d] = arr[i-1][d];
            list.add(arr[i-1][d]);
        }
        
        //가로줄(하단)
        for (int i=d-1;i>=b;i--){
            result[c][i] = arr[c][i+1];
            list.add(arr[c][i+1]);
        }
        
        //세로줄(좌측)
        for (int i=c-1;i>=a;i--){
            result[i][b] = arr[i+1][b];
            list.add(arr[i+1][b]);
        }
        Collections.sort(list);
        answer.add(list.get(0));
        return result;
    }
    
    int[][] copy(int[][] arr){
        int[][] result = new int[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }
}