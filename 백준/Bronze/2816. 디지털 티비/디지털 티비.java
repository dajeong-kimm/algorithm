import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i=0;i<N;i++) {
			arr[i] = br.readLine();
		}
		
		//KBS1을 제일 위로 올리기
		for (int i=0;i<N;i++) {
			if (arr[i].equals("KBS1")) {
				for (int j=i-1;j>=0;j--) {
					String tmp = arr[j];
					arr[j] = "KBS1";
					arr[j+1] = tmp;
					sb.append("4");
				}
				break;
			} else {
				sb.append("1");
			}
		}
		
		//KBS2를 두번째로 올리기
		sb.append("1");
		for (int i=1;i<N;i++) {
			if (arr[i].equals("KBS2")) {
				for (int j=i-1;j>=1;j--) {
					String tmp = arr[j];
					arr[j] = "KBS2";
					arr[j+1] = tmp;
					sb.append("4");
				}
				break;
			} else {
				sb.append("1");
			}
		}
		
		System.out.println(sb);

	}

}
