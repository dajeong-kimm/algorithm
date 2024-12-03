import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		sb.append(2000).append("\n");
		
		for (int i=0;i<1000;i++) {
			sb.append(1).append(" ");
		}
		for (int i=0;i<1000;i++) {
			sb.append(1000).append(" ");
		}
		System.out.println(sb);

	}

}