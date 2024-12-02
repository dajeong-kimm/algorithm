import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[][] visited;
    static int answer = 0;
    static final int MAX = 500_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        visited = new boolean[MAX + 1][2];
        int result = bfs(N);

        System.out.println(result);
    }

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start][0] = true;

        while (!q.isEmpty()) {
            // 동생의 위치가 범위를 벗어나면 종료
            if (K > MAX) {
                return -1;
            }

            // 현재 시간의 짝수/홀수
            int parity = answer % 2;

            // 동생의 현재 위치에 방문 가능한지 확인
            if (K <= MAX && visited[K][parity]) {
                return answer;
            }

            // 현재 큐의 사이즈만큼 반복하여 현재 시간에 가능한 모든 위치를 탐색
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int current = q.poll();

                // 가능한 모든 이동 방법
                int[] nextPositions = {current - 1, current + 1, current * 2};
                for (int next : nextPositions) {
                    if (next >= 0 && next <= MAX && !visited[next][1 - parity]) {
                        visited[next][1 - parity] = true;
                        q.add(next);
                    }
                }
            }

            // 시간 증가 및 동생의 위치 업데이트
            answer++;
            K += answer;
        }

        return -1;
    }
}