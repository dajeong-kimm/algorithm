import java.util.*;
class Solution {
    static class Music implements Comparable<Music> {
        int play;
        int num;
        
        Music(int play, int num) {
            this.play = play;
            this.num = num;
        }
        
        @Override
        public int compareTo(Music o) {
            if (play == o.play) {
                return Integer.compare(num, o.num);
            }
            return Integer.compare(o.play, play);
        }
    }
    
    static class Genre implements Comparable<Genre> {
        int id;
        int play;
        
        Genre(int id, int play) {
            this.id = id;
            this.play = play;
        }
        
        @Override
        public int compareTo(Genre o) {
            return Integer.compare(o.play, play);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;
        List<Integer> list = new ArrayList<>();
        
        List<Music> musicList[] = new ArrayList[100];
        for (int i=0;i<100;i++) {
            musicList[i] = new ArrayList<>();
        }
        
        Genre[] genreArr = new Genre[100];
        for (int i=0;i<100;i++){
            genreArr[i] = new Genre(i, 0);
        }
        
        Map<String, Integer> map = new HashMap<>();
        List<Genre> genreList = new ArrayList<>();
        
        int idx = 0;
        for (int i=0;i<N;i++) {
            String cur = genres[i];
            
            if (!map.containsKey(cur)) {
                map.put(cur, idx);
                genreList.add(new Genre(idx++, 0));
            }
            
            int id = map.get(cur);
            musicList[id].add(new Music(plays[i], i));
            genreList.get(id).play += plays[i];
        }
        
        Collections.sort(genreList);
        for (int i=0;i<idx;i++) {
            Genre genre = genreList.get(i);
            int id = genre.id;
            
            Collections.sort(musicList[id]);
            for (int j=0;j<Math.min(musicList[id].size(), 2);j++) {
                list.add(musicList[id].get(j).num);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        

        
        
        
        return answer;
    }
}