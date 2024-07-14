import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int[] change_switch(int[] arr, int gen, int num){
        if (gen == 1){
            for (int i=num-1;i<arr.length;i+=num){
                arr[i] ^= 1;
            }

        }else if (gen == 2){
            arr[num-1] ^= 1;
            int k = 1;
            while (true){
                if (num-k <1 || num+k>arr.length) break;
                else{
                    if (arr[num-1-k] == arr[num-1+k]) {
                        arr[num-1-k] ^= 1;
                        arr[num-1+k] ^= 1;
                        k++;
                    } else {
                        break;
                    }
                }
            }

        }


        return arr;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int NUM = Integer.parseInt(br.readLine());
        for (int i=0;i<NUM;i++){
            st = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            arr = change_switch(arr,gen,num);
//            for (int j : arr) {
//                System.out.print(j + " ");
//            }
        }

        for (int i=0;i<arr.length;i++){
            if (i!=0 && i%20 == 0) System.out.println();
            System.out.print(arr[i]+" ");
        }



    }
}