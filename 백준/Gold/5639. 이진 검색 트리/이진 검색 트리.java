import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 이진검색트리
 * 전위 순회한 결과가 주어졌을 때, 
 * 이 트리를 후위순회한 결과를 구하는 프로그램 
 * @author KOREA
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> arr = new ArrayList<>();
		String input;
		while ((input = br.readLine())!= null && !input.isEmpty()) {
			try {
				int x = Integer.parseInt(input);
				arr.add(x);
				
			} catch (Exception e) {
				break;
			}
			
			
		}
		
		solution(arr);
	}
	public static void solution(ArrayList<Integer> arr) {
		if (arr.size() ==0) {
			return;
		}
		
		ArrayList<Integer> tmpL = new ArrayList<>();
		ArrayList<Integer> tmpR = new ArrayList<>();
		int mid = arr.get(0);
		
		for (int i=1;i<arr.size();i++) {
			if (arr.get(i) > mid) {
				tmpL = new ArrayList<>(arr.subList(1, i));
				tmpR = new ArrayList<>(arr.subList(i, arr.size()));
				break;
			}
		}
		
		if (tmpL.isEmpty() && tmpR.isEmpty()) {
			tmpL = new ArrayList<>(arr.subList(1, arr.size()));
		}
		
		solution(tmpL);
		solution(tmpR);
		System.out.println(mid);
	}

}