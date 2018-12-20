public class TokenPass {
    private int[] board;
    private int currentPlayer;
    private int playerCount;
    public TokenPass(int playerCount){
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++){
            board[i] = 1 + (int)(10*Math.random());
        }
        currentPlayer = (int) (playerCount*Math.random());
        this.playerCount = playerCount;
    }
    public void distributeCurrentPlayerTokens(){
        int nextPlayer = currentPlayer;
        int numToDistribute = board[currentPlayer];
        board[currentPlayer] = 0;
        while (numToDistribute > 0){
            nextPlayer = (nextPlayer +1)% board.length;
            board[nextPlayer]++;
            numToDistribute--;
        }
    }
    public void printBoard(){
        System.out.println("\n\n\n=============================================");

        for (int i = 0; i < playerCount; i++){
            System.out.println("Player " + i + ": " + board[i] + " tokens.");
        }
    }
    public void nextPlayer(){
        currentPlayer++;
        currentPlayer = currentPlayer % playerCount;
    }

    public int gameover(){
        int num = -1;
        for (int i = 0; i < playerCount; i++){
            if(board[i] == 0){
                num = i;
            }
        }
        return num;
    }
}
