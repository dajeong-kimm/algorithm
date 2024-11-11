import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 상근이가 훔칠 수 있는 문서의 최대 개수
 * . 빈공간
 * * 벽 
 * $ 훔쳐야하는 문서
 * 대문자 : 문
 * 소문자 : 열쇠 
 * 그 문자의 대문자인 모든 문을 열 수 있음
 * 열쇠는 여러번 사용할 수 있음
 * @author KOREA
 *
 */
public class Main {
	static int h,w;
	static boolean[] key; //key를 주우면 true로 표시
	static char[][] arr;
	static boolean[][] visited;
	
	static ArrayList<int[]> doors[];
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			arr = new char[h+2][w+2];
			for (int i=0;i<h+2;i++) {
				Arrays.fill(arr[i], '.');
			}
			
			for (int i=1;i<=h;i++) {
				String input = br.readLine();
				for (int j=1;j<=w;j++) {
					arr[i][j] = input.charAt(j-1);
				}
			}
			
			key = new boolean[26];
			doors = new ArrayList[26]; // 문 위치를 저장
			for (int i = 0; i < 26; i++) {
                doors[i] = new ArrayList<>();
            }
			
			//이미 가지고 있는 열쇠
			String str = br.readLine();
			if (!str.equals("0")) {
				for (int i=0;i<str.length();i++) {
					key[str.charAt(i)-'a'] = true;
				}
			}
			
			answer = 0;
			
			bfs();
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		visited = new boolean[h+2][w+2];
		
		//빌딩 외곽의 빈 공간을 큐에 추가
		for (int i=0;i<h+2;i++) {
			for (int j=0;j<w+2;j++) { 
				if (arr[i][j] == '.') {
					//외곽이라면?
					if (i == 0 || i == h+1 || j == 0 || j == w+1) {
						queue.add(new int[] {i,j});
						visited[i][j] = true;
					}
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int i=0;i<4;i++) {
				int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;
                if (visited[nx][ny]) continue;

                char cell = arr[nx][ny];
                if (cell == '*') continue;

                visited[nx][ny] = true;

                if (cell == '$') {
                    answer++;
                    queue.add(new int[]{nx, ny});
                } else if (cell >= 'a' && cell <= 'z') { // 열쇠 발견
                    if (!key[cell - 'a']) {
                        key[cell - 'a'] = true;
                        for (int[] door : doors[cell - 'a']) {
                            queue.add(door);
                        }
                        doors[cell - 'a'].clear();
                    }
                    queue.add(new int[]{nx, ny});
                } else if (cell >= 'A' && cell <= 'Z') { // 문 발견
                    if (key[cell - 'A']) {
                        queue.add(new int[]{nx, ny});
                    } else {
                        doors[cell - 'A'].add(new int[]{nx, ny});
                    }
                } else if (cell == '.') {
                    queue.add(new int[]{nx, ny});
                }
			}
		}
		
	}
	
	static int getKeyState() {
		int state = 0;
		for (int i=0;i<26;i++) {
			if (key[i]) state |= (1<<i);
		}
		return state;
	}
	

}