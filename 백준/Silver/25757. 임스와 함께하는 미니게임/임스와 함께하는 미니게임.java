// 윷놀이, 같은 그림 찾기, 원카드 (2명, 3명, 4명)
// 같이 하기를 신청한 횟수 N, 플레이할 게임의 종류 --> 최대 몇번이나 임스와 함께 게임을 플레이 할 수 있는지
// 임스는 한 번 같이 플레이한 사람과는 다시 플레이 하지 않는다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        String game = line[1];
        HashSet<String> set = new HashSet<>();
        for (int i=0;i<N;i++){
            String name = br.readLine();
            set.add(name);
        }
        int set_size = set.size();
        int answer = 0;
        if (game.equals("Y")) answer = set_size;
        else if (game.equals("F")) answer = set_size/2;
        else answer = set_size/3;

        System.out.println(answer);
    }
}