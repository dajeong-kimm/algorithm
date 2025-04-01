import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int X = 0;
		int[] relative = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == B) X = i;
			if (num < B) relative[i] = -1;
			else if (num > B) relative[i] = 1;
		}
		
		int[] sumArr = new int[N+1];
		Map<Integer, Integer> leftMap = new HashMap<>();
		Map<Integer, Integer> rightMap = new HashMap<>();
		//X기준 왼쪽
		for (int i=X-1;i>=1;i--) {  
			sumArr[i] = sumArr[i+1] + relative[i];
			if (!leftMap.containsKey(sumArr[i])){
				leftMap.put(sumArr[i], 0);
			}
			leftMap.put(sumArr[i], leftMap.get(sumArr[i])+1);
		}
		
		//X기준 오른쪽
		for (int i=X+1;i<=N;i++) {
			sumArr[i] = sumArr[i-1] + relative[i];
			if (!rightMap.containsKey(sumArr[i])){
				rightMap.put(sumArr[i], 0);
			}
			rightMap.put(sumArr[i], rightMap.get(sumArr[i])+1);
		}
		
		int answer = 1;
		if (leftMap.containsKey(0)) answer += leftMap.get(0);
		if (rightMap.containsKey(0)) answer += rightMap.get(0);
		for (int leftNum : leftMap.keySet()) {
			int rightNum = (-1)*leftNum;
			if (rightMap.containsKey(rightNum)) {
				answer += (leftMap.get(leftNum)*rightMap.get(rightNum));
			}
		}
		
		System.out.println(answer);
	}

}
