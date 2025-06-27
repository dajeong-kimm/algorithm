class Solution {
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static char[][] Board;
    public int solution(String[] board) {
        int a = 0;
        int b = 0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (board[i].charAt(j) == 'O') a++;
                else if (board[i].charAt(j) == 'X') b++;
            }
        }
        if (!(a==b || a==b+1)) return 0; //개수가 안맞으면
        
        Board = new char[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                Board[i][j] = board[i].charAt(j);
            }
        }
        
        boolean aWin = isWin('O');
        boolean bWin = isWin('X');
        
        if (aWin && bWin) return 0;
        if (aWin && a != b+1) return 0;
        if (bWin && a != b) return 0;
        return 1;
        
    }
    
    static boolean isWin(char ch) {
            for (int i=0;i<3;i++){
                if (Board[i][0] == ch && Board[i][1] == ch && Board[i][2] == ch) return true;
                if (Board[0][i] == ch && Board[1][i] == ch && Board[2][i] == ch) return true; 
            }
            
            if (Board[0][0] == ch && Board[1][1] == ch && Board[2][2]==ch) return true;
            if (Board[0][2] == ch && Board[1][1] == ch && Board[2][0] == ch) return true;
            return false;
        }

}