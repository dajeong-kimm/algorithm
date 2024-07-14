import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

//        int count = maxCount(N);
//        System.out.println(count);

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        int k = 0;
        int maxCount = 0;

        for (int i=N/2;i<=N;i++){
            int index = 0;
            arr.add(N);
            arr.add(i);
            while (true){
                k = arr.get(index)-arr.get(index+1);
                if (k<0) break;
                else {
                    arr.add(k);
                    index++;
                }
            }

            if(arr.size()>maxCount) {
                answer.clear();
                maxCount = arr.size();
                answer.addAll(arr);
            }

            arr.clear();
        }

        System.out.println(maxCount);
        for (int i=0;i<maxCount;i++){
            System.out.print(answer.get(i)+" ");
        }

    }
}