// 절반의 0과 절반의 1을 제거 --> 새로운 문자열
// 사전순으로 가장 빠른 것

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int num0 = 0;
        int num1 = 0;

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            sb.append(c);
            if (c=='0') num0++;
            else num1++;
        }

        num0 /= 2;
        num1 /= 2;

        for (int i=0;i<sb.length();i++){
            if (sb.charAt(i)=='1') {
                sb.setCharAt(i,'2');
                num1--;
            }
            if (num1==0) break;
        }

        for (int i=sb.length()-1;i>-1;i--){
            if(sb.charAt(i) == '0') {
                sb.setCharAt(i,'2');
                num0--;
            }
            if (num0 == 0) break;
        }

        for (int i=0;i<sb.length();i++){
            if (sb.charAt(i)=='1' || sb.charAt(i)=='0') {
                System.out.print(sb.charAt(i));
            }
        }
}}