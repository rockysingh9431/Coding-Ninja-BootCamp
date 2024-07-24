package src.tictactoe;

import java.util.Scanner;

public class TicTacToe {

  Player player1, player2;
  Board board;
  private int numPlayers;

  // Start Game
  public void startGame() {
    numPlayers = 0;
    Scanner s = new Scanner(System.in);
    if (player1 == null || player2 == null) {
      player1 = takePlayerInput(++numPlayers);
      player2 = takePlayerInput(++numPlayers);

      while (player1.getSymbol() == player2.getSymbol()) {
        System.out.println("Both players chose the same symbol. Please choose a different one.");
        player2.setSymbol(s.next().charAt(0));
      }
    }

    board = new Board(player1.getSymbol(), player2.getSymbol());
    boolean player1Turn = true;
    int status = Board.INCOMPLETE;
    while (status == Board.INCOMPLETE || status == Board.INVALIDMOVE) {
      if (player1Turn) {
        status = playerTurn(status, player1);
        if (status == Board.INVALIDMOVE) {
          System.out.println("Invalid Move !! Please try again !!!");
          continue;
        }

      } else {
        status = playerTurn(status, player2);
        if (status == Board.INVALIDMOVE) {
          System.out.println("Invalid Move !! Please try again !!!");
          continue;
        }
      }

      player1Turn = !player1Turn;
      board.printBoard();
    }

    switch (status) {
      case Board.PLAYER1WINS -> System.out.println(player1.getName() + " wins!");
      case Board.PLAYER2WINS -> System.out.println(player2.getName() + " wins!");
      default -> System.out.println("DRAW !!!");
    }
    wantToPlayMore();
    s.close();
  }

  // Function to execute players turn and return the status of the game

  public int playerTurn(int status, Player player) {
    Scanner s = new Scanner(System.in);
    System.out.println(player.getName() + "'s turn and symbol:" + player.getSymbol());
    System.out.println("Enter x y:");
    int moveX = s.nextInt();
    int moveY = s.nextInt();
    return board.move(player.getSymbol(), moveX, moveY);

  }

  // After completion of game asks if player want to play more
  public void wantToPlayMore() {
    System.out.println("Do you want to play again? choose Yes or No");
    Scanner s = new Scanner(System.in);
    String s1 = s.nextLine();
    if ("yes".equals(s1.toLowerCase())) {
      startGame();
    } else {
      System.out.println("Thanks for playing!");
      s.close();
    }
  }

  // Function to take player Input

  public Player takePlayerInput(int playerNumber) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Player " + playerNumber + ", enter your name:");
    String name = scan.nextLine();
    System.out.println("Player " + playerNumber + ", choose a symbol (X or O):");
    char symbol = scan.next().charAt(0);
    return new Player(name, symbol);
  }

  public static void main(String[] args) {
    // GameController gameController = new GameController();
    // gameController.startGame();
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.startGame();
  }
}
