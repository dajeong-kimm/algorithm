import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 비밀번호
 * 주어진 하나의 양의 정수(A)에 대하여 다음의 원칙에 따라 두 수를 만들어서 비밀번호 제작
 * 1. A의 이진수 표현에서 나오는 1의 개수 x를 찾는다.
 * 2. A보다 작은 수 중에서 그 수의 이진수 표현에서 1의 개수가 x와 같고 A에 가장 가까운 수를 하나 찾는다.
 * 3. A보다 큰수 중에서 그 수의 이진수 표현에서 1의 개수가 x와 같고 A에 가장 가까운 수를 하나 찾는다.
 * 
 * 이 두수를 찾아 풀력하는 프로그램
 * 만약 그러한 수가 존재하지 않으면 그 수에 대해서는 0을 출력
 * 
 * 완전탐색 -> 시간 초과
 * 
 * @author KOREA
 *
 */
public class Main {
	static long A;
	static int cnt;
	
	static List<Integer> smallList = new ArrayList<>();
	static List<Integer> bigList = new ArrayList<>();
	
	static long small;
	static long big;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Long.parseLong(br.readLine());
		
		long X = A;
		
		cnt = 0;
		while (A>0L) {
			smallList.add((int) (A%2));
			bigList.add((int)(A%2));
			if ((int)(A%2) ==1) cnt++;
			
			A = A/2;
		}
		smallList.add(0);
		bigList.add(0);
		System.out.println(small() + " " + big());
		

	}
	public static long small() {
		int i;
		//첫번째로 '01'이 나타나는 위치를 찾아서 -> '10'
		for (i=1;i<smallList.size();i++) {
			if (smallList.get(i) == 1 && smallList.get(i-1) == 0) {
				smallList.set(i, 0);
				smallList.set(i-1, 1);
				break; //패턴을 찾으면 즉시 반복문 종료
			}
		}
		
		//'01'패턴을 찾지 못하면 더 작은 수를 만들 수 없음
		if (i == smallList.size()) return 0;
		
		//'10'을 찾은 이후 앞부분을 전부 0으로 만들어줌
		for (int  j=0;j<i;j++) {
			smallList.set(j, 0);
		}
		
		//현재 리스트에서 1의 개수를 계산
		int count=0;
		for (int j=0;j<smallList.size();j++) {
			if (smallList.get(j) == 1) count++;
		}
		
		//원래 수에서 1의 개수 cnt
		//cnt-count 만큼 앞부분에 1을 채워줌
		for (int j=0;j<cnt-count;j++) {
			smallList.set(i-1-j,1);
		}
		
		return toDecimal(smallList);
	}
	
	public static long big() {
		int i;
		for (i=1;i<bigList.size();i++) {
			if (bigList.get(i) == 0 && bigList.get(i-1) == 1) {
				bigList.set(i, 1);
				bigList.set(i-1, 0);
				break;
			}
		}
		if (i == bigList.size()) return 0;
		
		for (int j=0;j<i;j++) {
			bigList.set(j, 0);
		}
		
		int count = 0;
		for (int j=0;j<bigList.size();j++) {
			if (bigList.get(j) == 1) count++;
		}
		
		for (int j=0;j<cnt-count;j++) {
			bigList.set(j, 1);
		}
		
		return toDecimal(bigList);
	}
	
	public static Long toDecimal(List<Integer> list) {
		Long result=0L;
		Long bin = 1L;
		
		for (int i=0;i<list.size();i++) {
			result += bin * (long) list.get(i);
			bin *= 2L;
		}
		return result;
	}
	
		
	}