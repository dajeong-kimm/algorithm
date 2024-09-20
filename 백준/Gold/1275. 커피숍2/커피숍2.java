import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new long[N * 4];
        init(1, N, 1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x와 y가 역순으로 입력될 경우 처리
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 구간합 출력
            System.out.println(sumFind(1, N, 1, x, y));

            // 업데이트: b로 갱신할 값의 차이 계산
            long diff = b - (long)arr[a];
            update(1, N, 1, a, diff);
            arr[a] = b; // arr[a] 값을 갱신
        }
    }

    // 세그먼트 트리 초기화
    public static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    // 구간합을 구하는 함수
    public static long sumFind(int start, int end, int node, int left, int right) {
        if (end < left || start > right) return 0; // 범위 밖

        if (left <= start && end <= right) { // 범위 내
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sumFind(start, mid, node * 2, left, right) + sumFind(mid + 1, end, node * 2 + 1, left, right);
    }

    // 업데이트 함수
    public static void update(int start, int end, int node, int idx, long diff) {
        if (idx < start || end < idx) return; // 범위 밖

        // 트리 노드를 업데이트
        tree[node] += diff;

        if (start != end) { // 리프 노드가 아닌 경우
            int mid = (start + end) / 2;
            update(start, mid, node * 2, idx, diff);
            update(mid + 1, end, node * 2 + 1, idx, diff);
        }
    }
}