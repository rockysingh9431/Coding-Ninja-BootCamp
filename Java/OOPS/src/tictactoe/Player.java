package src.tictactoe;

public class Player {
  private String name;
  private char symbol;

  public Player(String name, char symbol) {
    this.name = name;
    this.symbol = symbol;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name.length() == 0) {
      System.out.println("Enter a valid Name");
    }
    this.name = name;
  }

  public char getSymbol() {
    return symbol;
  }

  public void setSymbol(char symbol) {
    if (symbol == '\0')
      System.out.println("Enter a valid symbol");
    this.symbol = symbol;
  }
}
