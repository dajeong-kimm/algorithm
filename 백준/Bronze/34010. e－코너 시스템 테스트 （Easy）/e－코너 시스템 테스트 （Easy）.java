import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for (int i=0;i<2*N-1;i++) {
			br.readLine();
		}
		int dist = (N-1)*2;
		
		System.out.println(dist+" "+(dist-1));
	}

}
