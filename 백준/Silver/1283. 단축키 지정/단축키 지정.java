import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[26];
		int num;
		
		for (int i=0;i<N;i++) {
			boolean flag = false;
			String[] arr = br.readLine().split(" ");
			for (int j=0;j<arr.length;j++) { //첫글자 단축키 시도
				char first = arr[j].charAt(0);
				if (first >= 'a' && first <= 'z') {
					num = first-'a';
				} else {
					num = first-'A';
				}
				if (!visited[num]) {
					visited[num] = true;
					arr[j] = "["+first+"]"+arr[j].substring(1);
					flag = true;
					break;
				}
			}
			if (!flag) {
				for (int j=0;j<arr.length;j++) {
					for (int k=1;k<arr[j].length();k++) {
						char cur = arr[j].charAt(k);
						if (cur >= 'a' && cur <= 'z') {
							num = cur-'a';
						} else {
							num = cur-'A';
						}
						if (!visited[num]) {
							visited[num] = true;
							arr[j] = arr[j].substring(0,k)+"["+cur+"]"+arr[j].substring(k+1);
							flag = true;
							break;
						}
					}
					if (flag) break;
				}
			}
			
			for (int j=0;j<arr.length;j++) {
				sb.append(arr[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
