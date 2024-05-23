// 자주 나오는 단어 앞에
// 길이가 길수록 앞에
// 알파벳 사전순 앞일수록 앞에
// 길이가 M이상인 단어들만

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] words = new String[N];
        for (int i=0;i<N;i++){
            words[i] = br.readLine();
        }
        br.close();

        List<String> result = findSolution(words);

        for (int i=0;i<result.size();i++){
            if (result.get(i).length() < M) continue;
            bw.write(result.get(i) + "\n");
        }
        bw.flush();
        bw.close();


    }

    static List<String> findSolution(String[] array) {
        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (mp.containsKey(array[i])) {
                mp.put(array[i], mp.get(array[i]) + 1);
            } else {
                mp.put(array[i], 1);
            }
        }

        List<String> wordList = mp.keySet().stream().collect(Collectors.toList());

        wordList.sort((o1, o2) -> {
            int c1 = mp.get(o1);
            int c2 = mp.get(o2);

            if (c1 == c2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return c2 - c1;
        });

        return wordList;
    }
}