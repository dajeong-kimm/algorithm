import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] startTimes = new int[N];
        int[] endTimes = new int[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            startTimes[i] = Integer.parseInt(st.nextToken());
            endTimes[i] = Integer.parseInt(st.nextToken());
        }
        
        // 시작 시간과 종료 시간 배열을 각각 정렬
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int rooms = 0;
        int maxRooms = 0;
        int startPointer = 0, endPointer = 0;
        
        // 시작 시간과 종료 시간을 비교하면서 회의실을 배정
        while (startPointer < N) {
            if (startTimes[startPointer] < endTimes[endPointer]) {
                // 새로운 회의 시작 -> 회의실 추가
                rooms++;
                startPointer++;
            } else {
                // 회의 종료 -> 회의실 반환
                rooms--;
                endPointer++;
            }
            // 현재 사용 중인 회의실의 최대 개수 기록
            maxRooms = Math.max(maxRooms, rooms);
        }
        
        System.out.println(maxRooms);
    }
}