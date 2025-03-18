import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//최소성능을 이분탐색
public class Main {
	static int n, b;
	static Map<String, List<Node>> map;
	
	static class Node implements Comparable<Node>{
		int price, quality;
		
		Node(int price, int quality) {
			this.price = price;
			this.quality = quality;
		}
		
		@Override
		//가격 낮은 순으로 가격 같다면 퀄리티 높은 순으로?
		public int compareTo(Node o) {
			if (price == o.price) {
				return Integer.compare(o.quality, quality);
			}
			return Integer.compare(price, o.price);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			map = new HashMap<>();
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				String type = st.nextToken();
				String name = st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				int quality = Integer.parseInt(st.nextToken());
				
				if (!map.containsKey(type)) {
					map.put(type, new ArrayList<>());
				}
				
				map.get(type).add(new Node(price, quality));
			}
			
			//정렬기준에 따라 각 리스트 정렬
			for (String type : map.keySet()) {
				Collections.sort(map.get(type));
			}
			
			int start = 0;
			int end = 1_000_000_000;
			int answer = 0;
			while (start<=end) {
				int mid = (start+end)/2;
				if (canBuy(mid)) {
					answer = mid;
					start = mid+1;
				} else {
					end = mid-1;
				}
				
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	
	
	static boolean canBuy(int minQuality) {
		long curMoney = 0;
		for (String type : map.keySet()) {
			List<Node> list = map.get(type);
			boolean flag = false;
			for (Node cur : list) {
				if (cur.quality >= minQuality) {
					curMoney += cur.price;
					if (curMoney > b) return false; //도중에 예산 초과하면
					flag = true;
					break;
				}
			}
			if (!flag) return false; //특정 부품을 맞추지 못하면?
			
		}
		return true;
	}

}
