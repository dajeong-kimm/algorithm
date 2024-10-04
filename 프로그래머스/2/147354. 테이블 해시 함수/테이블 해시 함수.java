/**
첫번째 열은 기본키 --> 모든 튜플에 대해 중복되지 않도록 보장

col번째 컬럼의 값을 기준으로 오름차순 ,,, 동일하면 기본키를 기준으로 내림차순
S_i : i번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합'
row_begin<=i<=row_end인 모든 S_i를 누적하여 bitwise XOR 한 값
*/
import java.util.*;
class Solution {
    Data[] dataArr;
    class Data implements Comparable<Data>{
        int colValue;
        int key;
        int idx;
        Data(int colValue, int key, int idx){
            this.colValue = colValue;
            this.key = key;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Data o){
            if (colValue != o.colValue){
                return colValue - o.colValue;
            }
            return o.key - key;
        }
    }
    int N,M;
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        N = data.length;
        M = data[0].length;
        dataArr = new Data[N];
        for (int i=0;i<N;i++){
            int colValue = data[i][col-1];
            int key = data[i][0];
            dataArr[i] = new Data(colValue, key, i);
        }
        Arrays.sort(dataArr);
        
        int answer = hash(data[dataArr[row_begin-1].idx], row_begin);
        
        for (int i=row_begin+1; i<=row_end;i++){
            int other = hash(data[dataArr[i-1].idx], i);
            answer ^= other;
        }
        
        return answer;
    }
    int hash(int[] arr, int num){
        int result = 0;
        for (int i=0;i<M;i++){
            result += (arr[i]%num);
        }
        return result;
    }
}