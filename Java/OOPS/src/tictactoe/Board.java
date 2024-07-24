package src.tictactoe;

public class Board {
  private char board[][];
  private int boardSize = 3;
  private char p1Symbol;
  @SuppressWarnings("unused")
  private char p2Symbol;
  private int count;
  private final static char EMPTY = ' ';
  final static int PLAYER1WINS = 1;
  final static int PLAYER2WINS = 2;
  final static int DRAW = 3;
  final static int INCOMPLETE = 4;
  final static int INVALIDMOVE = 5;

  public Board(char p1Symbol, char p2Symbol) {
    board = new char[boardSize][boardSize];

    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        board[i][j] = EMPTY;
      }
    }
    this.p1Symbol = p1Symbol;
    this.p2Symbol = p2Symbol;
  }

  public int move(char symbol, int x, int y) {
    if (x < 0 || x >= boardSize || y < 0 || y >= boardSize || board[x][y] != EMPTY) {
      return INVALIDMOVE;
    }

    board[x][y] = symbol;
    count++;

    // check Row
    if (board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
      System.out.println("row");
      return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
    }
    // check col
    if (board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
      System.out.println("col");
      return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
    }
    // First Diagonal
    if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
      System.out.println("d1");
      return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
    }
    // Second Diagonal
    if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
      System.out.println("d2");
      return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
    }

    if (count == boardSize * boardSize) {
      return DRAW;
    }
    return INCOMPLETE;
  }

  public void printBoard() {
    System.out.println("_______________________");
    System.out.println();
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        System.out.print("| " + board[i][j] + " |");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("_______________________");
  }
}
