import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int[] reverseArr = new int[n];
        for (int i = 0; i < n; i++) {
            reverseArr[i] = arr[n - i - 1];
        }
        
        int[] increase = new int[n];
        int[] decrease = new int[n];
        for (int i = 0; i < n; i++) {
            increase[i] = 1;
            decrease[i] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    increase[i] = Math.max(increase[i], increase[j] + 1);
                }
                if (reverseArr[i] > reverseArr[j]) {
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
                }
            }
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = increase[i] + decrease[n - i - 1] - 1;
        }
        
        int maxResult = 0;
        for (int i = 0; i < n; i++) {
            maxResult = Math.max(maxResult, result[i]);
        }
        
        System.out.println(maxResult);
    }
}