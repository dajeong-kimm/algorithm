import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] ball = br.readLine().toCharArray();
		
		int blue = 0;
		for (int i=0;i<N;i++) {
			if (ball[i] == 'B') blue++;
		}
		int red = N - blue;
		
		int answer = Math.min(red, blue);
		
		//왼->오
		int cnt = 0;
		for (int i=0;i<N;i++) {
			if (ball[0] != ball[i]) break;
			cnt++;
		}
		
		if (ball[0] == 'R') {
			answer = Math.min(answer, red-cnt);
		} else {
			answer = Math.min(answer, blue-cnt);
		}
		
		//오->왼
		cnt = 0;
		for (int i=N-1;i>=0;i--) {
			if (ball[N-1] != ball[i]) break;
			cnt++;
		}
		
		if (ball[N-1] == 'R') {
			answer = Math.min(answer, red-cnt);
		} else {
			answer = Math.min(answer, blue-cnt);
		}
		
		System.out.println(answer);
	}

}
