import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long answer;
	
	static int N, T;
	
	static Carrot[] list;
	
	//p가 큰 순으로
	static class Carrot implements Comparable<Carrot>{
		long w;
		long p;
		
		Carrot(long w, long p){
			this.w = w;
			this.p = p;
		}
		
		@Override
		public int compareTo(Carrot o) {
			if (p == o.p) {
				return Long.compare(o.w,  w);
			}
			return Long.compare(o.p,  p);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		list = new Carrot[N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			long w = Long.parseLong(st.nextToken());
			long p = Long.parseLong(st.nextToken());
			
			list[i] = new Carrot(w,p);
		}
		
		//영양제 큰 순으로 정렬
		Arrays.sort(list);
		
		answer = 0;
		for (int i=0;i<N;i++) {
			Carrot cur = list[i];
			
			//최대 (T-1-i)일만큼 키우기 가능
			answer += (cur.w + cur.p*(T-1-i));
		}
		System.out.println(answer);

	}

}
