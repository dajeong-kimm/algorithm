// N의 최솟값

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int pt = 0;

        int base = 0;
        boolean flag = false;
        while (base++ <= 30000){
            String tmp = String.valueOf(base);
            for (int i=0;i<tmp.length();i++){
                if (tmp.charAt(i) == s.charAt(pt)) pt++;
                if (pt == s.length()) {
                    System.out.println(base);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

    }
}