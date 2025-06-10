import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Player implements Comparable<Player> {
		int level;
		String name;
		
		Player(int level, String name) {
			this.level = level;
			this.name = name;
		}
		
		@Override
		public int compareTo(Player o) {
			return name.compareTo(o.name);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<List<Player>> room = new ArrayList<>();
		for (int i=0;i<p;i++) {
			room.add(new ArrayList<>());
		}
		int[] roomLevel = new int[p];
		int[] roomCnt = new int[p];
		for (int i=0;i<p;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			for (int j=0;j<p;j++) {
				if (roomCnt[j] == 0) {
					roomCnt[j]++;
					roomLevel[j] = l;
					room.get(j).add(new Player(l, name));
//					if (roomCnt[j] == m) {
//						sb.append("Started!").append("\n");
//						Collections.sort(room.get(j));
//						for (int k=0;k<m;k++) {
//							sb.append(room.get(j).get(k).level+" "+room.get(j).get(k).name).append("\n");
//						}
//					}
					break;
				} else if (roomCnt[j] >= m) continue;
				else {
					if (Math.abs(roomLevel[j]-l) <= 10) {
						room.get(j).add(new Player(l, name));
						roomCnt[j]++;
//						if (roomCnt[j] == m) {
//							sb.append("Started!").append("\n");
//							Collections.sort(room.get(j));
//							for (int k=0;k<m;k++) {
//								sb.append(room.get(j).get(k).level+" "+room.get(j).get(k).name).append("\n");
//							}
//						}
						break;
					}
				}
			}
		}
		
		for (int i=0;i<p;i++) {
			if (roomCnt[i] == m) {
				sb.append("Started!").append("\n");
				Collections.sort(room.get(i));
				for (int j=0;j<m;j++) {
					sb.append(room.get(i).get(j).level+" "+room.get(i).get(j).name).append("\n");
				}
			}
			else if (roomCnt[i] > 0 && roomCnt[i] < m) {
				sb.append("Waiting!").append("\n");
				Collections.sort(room.get(i));
				for (int j=0;j<roomCnt[i];j++) {
					sb.append(room.get(i).get(j).level+" "+room.get(i).get(j).name).append("\n");
				}
			}
		}
		System.out.println(sb);

		

	}

}
