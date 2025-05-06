import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int EM = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int MH = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		while (true) {
			//어려운
			if (H > 0) H--;
			else if (MH > 0) MH--;
			else break;
			//쉬운
			if (E>0) E--;
			else if (EM > 0) EM--;
			else break;
			
			//중간
			if (M>0) M--;
			else if (EM == 0 && MH == 0) break;
			else if (EM > MH) EM--;
			else if (EM < MH) MH--;
			else {
				if (H > E) MH--;
				else EM--;
			}
			answer++;
		}
		System.out.println(answer);

	}

}
