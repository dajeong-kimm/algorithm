import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        input = input.toLowerCase();
        int[] alpha = new int[26];

        for(char c : input.toCharArray()){
            int tmp = (int)(c-'a');
            alpha[tmp] += 1;
        }

        int max_count = 0;
        String answer = "";

        for (int i=0;i<26;i++){
            if(max_count<alpha[i]){
                char tmp_char = (char)(i+'A');
                max_count = alpha[i];
                answer = Character.toString(tmp_char);
            }
        }

        int tmp_count = 0;
        for (int i=0;i<26;i++){
            if (alpha[i] == max_count) tmp_count += 1;
        }

        if (tmp_count>1) answer = "?";
        System.out.println(answer);
    }
}