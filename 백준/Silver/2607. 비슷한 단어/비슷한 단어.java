// 두 개의 단어가 같은 종류의 문자로
// 같은 문자는 같은 개수 만큼
// 같은 구성을 갖는 경우, 한 단어에서 한 문자를 빼거나, 하나의 문자를 다른 문자로 바꾸어 ~ 비슷한 단어


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int result = 0;

        for (int i=0;i<N-1;i++){
            String str = br.readLine();
            int cnt = 0;
            int[] word = new int[26];
            for (int j=0;j<first.length();j++){
                word[first.charAt(j)-'A']++;
            }
            for (int j=0;j<str.length();j++){
                if (word[str.charAt(j)-'A']>0){
                    cnt++;
                    word[str.charAt(j)-'A']--;
                }
            }

            if (first.length() == str.length() && (first.length() == cnt || first.length()-1 == cnt)) {
                result++;
            }
            else if (first.length() == str.length()-1 && str.length()-1 == cnt){
                result++;
            }
            else if (first.length() == str.length()+1 && str.length()==cnt) {
                result++;
            }

        }
        System.out.println(result);


    }
}