// 1 켜져있음 0 꺼져있음
// 1~스위치개수
// 남학생 : 스위치 번호가 자기가 받은 수의 배수이면 바꿈
// 여학생 : 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간 (--> 스위치 개수는 항상 홀수)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] swit = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            swit[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        for (int i=0;i<m;i++){
            String[] line = br.readLine().split(" ");
            int gender = Integer.parseInt(line[0]);
            int number = Integer.parseInt(line[1]);
            if (gender == 1){
                int start = number;
                while (start<=n){
                    swit[start-1] = change(swit[start-1]);
                    start += number;
                }
            }
            else {
                int start = number;
                swit[start-1] = change(swit[start-1]);
                int distance = 1;
                while (true) {
                    if ((start-distance)>0 && (start+distance)<=n) {
                        if (swit[start-distance-1] == swit[start+distance-1]) {
                            swit[start-distance-1] = change(swit[start-distance-1]);
                            swit[start+distance-1] = change(swit[start+distance-1]);
                            distance += 1;
                        }
                        else break;
                    } else break;
                }
            }
        }
        for (int i=0;i<swit.length;i++){
            if (i != 0 && i%20 == 0) System.out.println();
            System.out.print(swit[i]+" ");
        }
    }
    public static int change(int num){
        if (num==0) return 1;
        return 0;
    }
}