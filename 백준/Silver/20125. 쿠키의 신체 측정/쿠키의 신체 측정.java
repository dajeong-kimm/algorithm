import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//점프, 슬라이드
// 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리의 길이
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        int head_x = 0;
        int head_y = 0;
        boolean first = false;
        for (int i=0;i<N;i++){
            String line = br.readLine();
            int j = 0;
            for (char l : line.toCharArray()){
                arr[i][j++] = l;
                if (!first && l=='*') {
                    head_x = i;
                    head_y = j-1;
                    first = true;
                }
            }
        }
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        for (int j=0;j<N;j++){
            if (arr[head_x+1][j]=='*'){
                if (j<head_y) a += 1;
                else if (j>head_y) b += 1;

            }
        }
        for (int i=head_x+2;i<N;i++){
            if (arr[i][head_y]=='*') c+= 1;
        }
        for (int i=head_x+3;i<N;i++){
            if (arr[i][head_y-1]=='*') d += 1;
            if (arr[i][head_y+1]=='*') e += 1;
        }
        System.out.println(head_x+2+" "+(head_y+1));
        System.out.println(a+" "+b+" "+c+" "+d+" "+e);
    }
}