import java.util.*;
class Solution {
    static class Word implements Comparable<Word> {
        String name;
        
        Word(String name) {
            this.name = name;
        }
        
        @Override
        public int compareTo(Word o) {
            String a = name+o.name;
            String b = o.name+name;
            
            return b.compareTo(a);
        }
    }
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int N = numbers.length;
        Word[] wordArr = new Word[N];
        for (int i=0;i<N;i++) {
            wordArr[i] = new Word(numbers[i]+"");
        }
        Arrays.sort(wordArr);
        
        if (wordArr[0].name.equals("0")) return "0";
        
        for (int i=0;i<N;i++) {
            sb.append(wordArr[i].name);
        }
        return sb.toString();
    }
}