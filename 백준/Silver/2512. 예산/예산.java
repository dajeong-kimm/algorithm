// 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정
// 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배ㅓㅈㅇ

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 0;
        for (int a : arr) {
            if (a>end) end = a;
        }
        int mid = 0;
        int answer = 0;
        while (start<=end) {
            mid = (start+end)/2;
            int total = 0;
            for (int a : arr){
                if (a>mid) total += mid;
                else total += a;
            }

            if (total<=M){
                start = mid+1;
                answer = mid;
            }
            else {
                end = mid-1;
            }
        }

        System.out.println(answer);

    }
}