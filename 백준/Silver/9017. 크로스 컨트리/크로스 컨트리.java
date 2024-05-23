import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 주자들이 자연적인 야외의 지형에 만들어진 코스를 달리는 운동 경기
// 개인성적 -> 팀의 점수
// 한 팀 여섯명, 상위 네명의 주자의 점수 합
// 가장 낮은 점수를 얻는 팀이 우승
// 여섯 명의 주자가 참가하지 못한 팀은 점수 계산에서 제외
// 동점의 경우에는 다섯 번째 주자가 가장 빨리 들어온 팀이 우승
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());
        int[] answer = new int[T];

        for (int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int[] ranks = new int[N];
            Map<Integer,Integer> countMap = new HashMap<>();
            st = new StringTokenizer(br.readLine()," ");
            int max = Integer.MIN_VALUE;
            for (int j=0;j<N;j++) {
                int data = Integer.parseInt(st.nextToken());
                countMap.put(data,countMap.getOrDefault(data,0)+1);
                ranks[j] = data;
                max = Math.max(max,data);
            }

            int[] fifthPlayer = new int[max+1];
            Map<Integer,Integer> scoreMap = new HashMap<>();
            Map<Integer,Integer> tmpMap = new HashMap<>();

            int score = 1;

            for (int rank: ranks) {
                if (countMap.get(rank) == 6) {
                    tmpMap.put(rank,tmpMap.getOrDefault(rank,0)+1);

                    if (tmpMap.get(rank) <= 4){
                        scoreMap.put(rank,scoreMap.getOrDefault(rank,0)+score);
                    }
                    if(tmpMap.get(rank) == 5) {
                        fifthPlayer[rank] = score;
                    }
                    score++;
                }
            }

            int result = Integer.MAX_VALUE;
            int fifthScore = Integer.MAX_VALUE;

            for (Integer key : scoreMap.keySet()) {
                int tmp = scoreMap.get(key);
                if (tmp<result) {
                    result = tmp;
                    fifthScore = fifthPlayer[key];
                    answer[i] = key;
                } else if (tmp==result) {
                    if(fifthScore>fifthPlayer[key]) {
                        answer[i] = key;
                    }
                }
            }


        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}